package cn.abbenyyy.imitation_daily.service;

import cn.abbenyyy.imitation_daily.domain.News;
import cn.abbenyyy.imitation_daily.domain.NewsColumn;
import cn.abbenyyy.imitation_daily.responsitory.NewsColumnRepository;
import cn.abbenyyy.imitation_daily.responsitory.NewsRepository;
import cn.abbenyyy.imitation_daily.result.BannerBean;
import cn.abbenyyy.imitation_daily.result.HomePageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;
    private final NewsColumnRepository newsColumnRepository;
    private final int bannerSize = 5;
    private Logger logger = LoggerFactory.getLogger(NewsService.class);

    @Autowired
    public NewsService(NewsRepository newsRepository, NewsColumnRepository newsColumnRepository) {
        this.newsRepository = newsRepository;
        this.newsColumnRepository = newsColumnRepository;
    }

    public List<BannerBean> fetchBannerAndFormat() {
        List<BannerBean> bannerNewsList = new ArrayList<>();
        List<News> newsList = newsRepository.findByCssColumn(2, PageRequest.of(0, bannerSize));
        for (News n : newsList) {
            BannerBean bannerBean = new BannerBean(n, true);
            bannerNewsList.add(bannerBean);
        }
        return bannerNewsList;
    }

    /**
     * 构造首页数据，普通新闻（css_column相加=4）+1个投票、我说类新闻 + 1个新闻栏目 + 后续的普通新闻
     */
    public HomePageBean structureHomePage() {
        List<News> newsList = newsRepository.findMore(PageRequest.of(0, 20 + bannerSize));
        filterBannerNews(newsList);
        //构造正式返回数据集合
        List<News> otherNews = newsRepository.findCategoryIdLessThen2(PageRequest.of(0, 1));
        List<NewsColumn> columnList = newsColumnRepository.findLimitOneByColumnId(PageRequest.of(0, 1));
        List<BannerBean> homepageData = new ArrayList<>();
        int flag_count = 0;
        for (News news : newsList) {
            BannerBean homepageDataItem = new BannerBean(news);
            flag_count = flag_count + (int) news.getCssColumn().longValue();
            homepageData.add(homepageDataItem);
            if (flag_count == 4) {
                if (otherNews.size() > 0) {
                    BannerBean homepageDataItemOther = new BannerBean(otherNews.get(0));
                    homepageData.add(homepageDataItemOther);
                    flag_count++;
                }
                if (columnList.size() > 0) {
                    BannerBean homepageDataItemColumn = new BannerBean(columnList.get(0));
                    homepageData.add(homepageDataItemColumn);
                    flag_count++;
                }
            }
        }
        return new HomePageBean(homepageData, newsRepository.count() > (20 + bannerSize));
    }

    public HomePageBean findMoreHomePageData(long lastKey) {
        List<News> newsList = newsRepository.findMoreAfter(lastKey, PageRequest.of(0, 20 + bannerSize));
        boolean has_more = newsList.size() == (20 + bannerSize);
        filterBannerNews(newsList);
        return new HomePageBean(homepageDataContrusctor(newsList), has_more);
    }

    public HomePageBean findMoreHomePageDataByMobile(long lastKey) {
        List<News> newsList;
        if (lastKey == 0) {
            //首页
            newsList = new ArrayList<>(newsRepository.findAll(PageRequest.of(0, 20 + bannerSize,
                    new Sort(Sort.Direction.DESC, "createTime"))).getContent());
        } else {
            newsList = newsRepository.findMoreAfter(lastKey, PageRequest.of(0, 20 + bannerSize));
        }
        boolean has_more = newsList.size() == (20 + bannerSize);
        filterBannerNews(newsList);
        return new HomePageBean(homepageDataContrusctor(newsList), has_more);
    }


    /**
     * 过滤掉属于Banner的新闻
     *
     * @param newsList 需要过滤的新闻集合
     */
    private void filterBannerNews(List<News> newsList) {
        List<News> bannerNewsList = newsRepository.findByCssColumn(2, PageRequest.of(0, bannerSize));
        //因为新闻查询出来都是按照创建时间由大到小排序好的，所以只需找出newsList里面距离banner新闻第一条的时间最近的一个点
        //就可以从这个index到结尾查找是否有属于banner新闻的新闻
        if (bannerNewsList.size() > 0) {
            int similarIndex = selectSimilar(newsList, bannerNewsList.get(0).getCreateTime());
            int k = bannerNewsList.size() - 1;
            for (int i = newsList.size() - 1; i >= similarIndex; i--) {
                for (int j = k; j >= 0; j--) {
                    if (newsList.get(i).getId().longValue() == bannerNewsList.get(j).getId().longValue()) {
                        newsList.remove(i);
                        j = -1;
                        k--;
                    }
                }
            }
        }
    }

    private List<BannerBean> homepageDataContrusctor(List<News> newsList) {
        List<BannerBean> homepageData = new ArrayList<>();
        for (int i = 0; i < Math.min(20, newsList.size()); i++) {
            BannerBean homepageDataItem = new BannerBean(newsList.get(i));
            if (homepageDataItem.getCssColumn() == 0) {
                homepageDataItem.setCssColumn(2L);
            }
            homepageData.add(homepageDataItem);
        }
        return homepageData;
    }

    private int selectSimilar(List<News> newsList, Date bannerMaxTime) {
        int keyIndex = -1;
        int lo = 0;
        int hi = newsList.size() - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (newsList.get(mid).getCreateTime().equals(bannerMaxTime)) {
                keyIndex = mid;
                lo = hi + 1;
            } else if (newsList.get(mid).getCreateTime().before(bannerMaxTime)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (keyIndex == -1) {
            if (hi < 0) {
                keyIndex = lo;
            } else if (lo >= newsList.size()) {
                keyIndex = hi;
            } else {
                keyIndex = hi;
            }
        }
        return keyIndex;
    }

}
