package cn.abbenyyy.imitation_daily.controller;

import cn.abbenyyy.imitation_daily.domain.News;
import cn.abbenyyy.imitation_daily.responsitory.NewsRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @PostMapping("/save")
    public String save(@RequestBody News entity) {
        entity = newsRepository.save(entity);
        return "id:"+entity.getId();
    }



    @GetMapping
    public @ResponseBody News get(){
        return newsRepository.findById(1L).get();
    }
}
