package cn.abbenyyy.imitation_daily.controller;

import cn.abbenyyy.imitation_daily.domain.News;
import cn.abbenyyy.imitation_daily.responsitory.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
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

    @GetMapping("/get")
    public @ResponseBody
    News get() {
        return newsRepository.findById(1L).get();
    }
}
