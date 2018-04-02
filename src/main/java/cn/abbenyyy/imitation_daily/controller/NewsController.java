package cn.abbenyyy.imitation_daily.controller;

import cn.abbenyyy.imitation_daily.result.BannerBean;
import cn.abbenyyy.imitation_daily.result.HomePageBean;
import cn.abbenyyy.imitation_daily.service.NewsService;
import cn.abbenyyy.imitation_daily.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/banner")
    public Result<List<BannerBean>> fetchBanner() {
        return Result.ok(newsService.fetchBannerAndFormat());
    }

    @GetMapping("/homepage")
    public Result<HomePageBean> fetchHomePageData() {
        return Result.ok(newsService.structureHomePage());
    }

    @GetMapping("/articlemore")
    public Result<HomePageBean> fetchMoreHomePageData(@RequestParam(name = "lastId", defaultValue = "-1") long lastKey) {
        return lastKey == -1L ? Result.badRequest() : Result.ok(newsService.findMoreHomePageData(lastKey));
    }

    @GetMapping("/mobile/articlemore")
    public Result<HomePageBean> fetchMoreHomePageDataByMobile(@RequestParam(name = "lastId", defaultValue = "-1") long lastKey){
        return lastKey == -1L ? Result.badRequest() : Result.ok(newsService.findMoreHomePageDataByMobile(lastKey));
    }
}
