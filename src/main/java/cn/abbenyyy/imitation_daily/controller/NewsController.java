package cn.abbenyyy.imitation_daily.controller;

import cn.abbenyyy.imitation_daily.domain.News;
import cn.abbenyyy.imitation_daily.responsitory.NewsRepository;
import cn.abbenyyy.imitation_daily.result.BannerBean;
import cn.abbenyyy.imitation_daily.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/homes")
public class NewsController {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @PostMapping("/save")
    public String save(@RequestBody News entity) {
        entity = newsRepository.save(entity);
        return "id:" + entity.getId();
    }

    @GetMapping("/articlemore")
    public Result<List<BannerBean>> fetchArticleMore(@RequestParam(name = "page",defaultValue = "0") int page) {
        List<BannerBean> moreNewsList = new ArrayList<>();
        List<News> newsList = newsRepository.findByMore(PageRequest.of(page, 5));
        for(News n:newsList){
            BannerBean bannerBean = new BannerBean(n);
            moreNewsList.add(bannerBean);
        }
        return Result.ok(moreNewsList);
    }

    @GetMapping("/banner")
    public Result<List<BannerBean>> fetchBanner() {
        List<BannerBean> bannerNewsList = new ArrayList<>();
        List<News> newsList = newsRepository.findByCssColumn(2, PageRequest.of(0, 5));
        for(News n:newsList){
            BannerBean bannerBean = new BannerBean(n);
            bannerNewsList.add(bannerBean);
        }
        return Result.ok(bannerNewsList);
    }


//    试验原生SQL语句
//    @GetMapping("/nativeQuery")
//    public Result<List<String>> fetchAll(@RequestParam(name = "page",defaultValue = "0") int page,
//                                         @RequestParam(name = "pageSize",defaultValue = "5") int pageSize) {
//        List<Object[]> objectList = newsRepository.findByNativeSQL(page, pageSize);
//        System.out.println("Size:" + objectList.size());
//        List<String> result = new ArrayList<>();
//        for (Object[] objects : objectList) {
////            System.out.println(objects[1].toString());
//            result.add(objects[1].toString());
////            for(Object o:objects){
////                System.out.println(o.toString());
////            }
//        }
//        return Result.ok(result);
//    }
}
