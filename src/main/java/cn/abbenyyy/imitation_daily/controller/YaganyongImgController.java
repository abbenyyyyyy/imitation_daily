package cn.abbenyyy.imitation_daily.controller;

import cn.abbenyyy.imitation_daily.domain.YaganyongImg;
import cn.abbenyyy.imitation_daily.service.YaganyongImgService;
import cn.abbenyyy.imitation_daily.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wxapp")
public class YaganyongImgController {
    private final YaganyongImgService yaganyongImgService;

    @Autowired
    public YaganyongImgController(YaganyongImgService yaganyongImgService) {
        this.yaganyongImgService = yaganyongImgService;
    }

    @GetMapping("/moreimg")
    public Result<List<YaganyongImg>> findMoreYaganyongImg(
            @RequestParam(name = "page", defaultValue = "-1") int page,
            @RequestParam(name = "pageSize", defaultValue = "-1") int size
    ) {
        if (page == -1 || page == 0 || size == -1 || size == 0) {
            return Result.badRequest();
        } else {
            return Result.okWithNext(yaganyongImgService.findMoreYaganyongImg(page, size), yaganyongImgService.hasNext(page, size));
        }
    }

    @GetMapping("/fetchTopLikes")
    public Result<YaganyongImg> findTopLikesImg() {
        return Result.ok(yaganyongImgService.findTopLikesImg());
    }

    /**
     * 点赞
     *
     * @param changeId 点赞条目的id
     */
    @GetMapping("/postLikes")
    public Result<Integer> postLikes(@RequestParam(name = "id", defaultValue = "-1") Long changeId) {
        return changeId == -1L ? Result.badRequest() : Result.ok(yaganyongImgService.incrementLikes(changeId));
    }

}
