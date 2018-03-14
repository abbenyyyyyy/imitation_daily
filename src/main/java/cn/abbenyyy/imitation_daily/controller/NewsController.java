package cn.abbenyyy.imitation_daily.controller;

import cn.abbenyyy.imitation_daily.domain.News;
import cn.abbenyyy.imitation_daily.responsitory.NewsRepository;
import cn.abbenyyy.imitation_daily.result.FirstBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return newsRepository.findById(2211L).get();
    }

//    @GetMapping("/all")
//    public @ResponseBody List<FirstBean> find(){
//        return newsRepository.findAllHaveCategoryName();
//    }

    @GetMapping("/hi")
    public String fetchAll(){
        List<Object[]> objectList = newsRepository.findAllHaveCategoryName(0,20);
        System.out.println("Size:"+objectList.size());
        for(Object[] objects:objectList){
            System.out.println(objects[1].toString());
//            for(Object o:objects){
//                System.out.println(o.toString());
//            }
        }
        return "Hi";
    }
}
