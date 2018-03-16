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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;
    private final NewsColumnRepository newsColumnRepository;
    private Logger logger = LoggerFactory.getLogger(NewsService.class);

    @Autowired
    public NewsService(NewsRepository newsRepository, NewsColumnRepository newsColumnRepository) {
        this.newsRepository = newsRepository;
        this.newsColumnRepository = newsColumnRepository;
    }

    public List<BannerBean> fetchBannerAndFormat() {
        long begin = System.currentTimeMillis();
        List<BannerBean> bannerNewsList = new ArrayList<>();
        List<News> newsList = newsRepository.findByCssColumn(2, PageRequest.of(0, 5));
        for (News n : newsList) {
            BannerBean bannerBean = new BannerBean(n);
            bannerNewsList.add(bannerBean);
        }
        logger.info("end 耗时: " + (System.currentTimeMillis() - begin));
        return bannerNewsList;
    }

    /**
     * 构造首页数据，普通新闻（css_column相加=4）+1个投票、我说类新闻 + 1个新闻栏目 + 后续的普通新闻
     */
    public HomePageBean structureHomePage() {
        long begin = System.currentTimeMillis();
        List<News> newsList = newsRepository.findMore(PageRequest.of(0, 25));

        List<News> bannerNewsList = newsRepository.findByCssColumn(2, PageRequest.of(0, 5));
        Iterator<News> iterator = newsList.iterator();
        while (iterator.hasNext()) {
            News news = iterator.next();
            for (News banner : bannerNewsList) {
                if (news.getId().longValue() == banner.getId().longValue()) {
                    iterator.remove();
                }
            }
        }
        List<News> otherNews = newsRepository.findCategoryIdLessThen2(PageRequest.of(0, 1));
        List<NewsColumn> columnList = newsColumnRepository.findLimitOneByColumnId(PageRequest.of(0, 1));

        //构造正式返回数据集合
        List<BannerBean> homepageData = new ArrayList<>();
        int flag_count = 0;
        for (News news : newsList) {
            BannerBean homepageDataItem = new BannerBean(news);
            flag_count = flag_count + (int) news.getCssColumn().longValue();
            homepageData.add(homepageDataItem);
            if (flag_count == 4) {
                logger.info("开始插入：");
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
        HomePageBean homePageBean = new HomePageBean(homepageData,newsRepository.count()>25);
        logger.info("end 耗时: " + (System.currentTimeMillis() - begin));
        return homePageBean;
    }

}
