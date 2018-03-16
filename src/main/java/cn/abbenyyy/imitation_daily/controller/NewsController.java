package cn.abbenyyy.imitation_daily.controller;

import cn.abbenyyy.imitation_daily.result.BannerBean;
import cn.abbenyyy.imitation_daily.result.HomePageBean;
import cn.abbenyyy.imitation_daily.service.NewsService;
import cn.abbenyyy.imitation_daily.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/homes")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }


//    @PostMapping("/save")
//    public String save(@RequestBody News entity) {
//        entity = newsRepository.save(entity);
//        return "id:" + entity.getId();
//    }

//    @GetMapping("/articlemore")
//    public Result<List<BannerBean>> fetchArticleMore(@RequestParam(name = "page", defaultValue = "0") int page) {
//        List<BannerBean> moreNewsList = new ArrayList<>();
//        List<News> newsList = newsRepository.findByMore(PageRequest.of(page, 5));
//        for (News n : newsList) {
//            BannerBean bannerBean = new BannerBean(n);
//            moreNewsList.add(bannerBean);
//        }
//        return Result.ok(moreNewsList);
//    }

    @GetMapping("/banner")
    public Result<List<BannerBean>> fetchBanner() {
        return Result.ok(newsService.fetchBannerAndFormat());
    }

    @GetMapping("/homepage")
    public Result<HomePageBean> fetchHomePageData() {
        return Result.ok(newsService.structureHomePage());
    }

}
