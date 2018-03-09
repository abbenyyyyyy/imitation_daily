package cn.abbenyyy.imitation_daily.controller;

import cn.abbenyyy.imitation_daily.domain.News;
import cn.abbenyyy.imitation_daily.responsitory.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @PostMapping("/save")
    public String save(@RequestBody News entity) {
        entity = newsRepository.save(entity);
        return "id:"+entity.getId();
    }
}
