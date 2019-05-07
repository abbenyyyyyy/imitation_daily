package cn.abbenyyy.imitation_daily.service;

import cn.abbenyyy.imitation_daily.domain.YaganyongImg;
import cn.abbenyyy.imitation_daily.responsitory.YaganyongImgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YaganyongImgService {
    private final YaganyongImgRepository yaganyongImgRepository;

    @Autowired
    public YaganyongImgService(YaganyongImgRepository yaganyongImgRepository) {
        this.yaganyongImgRepository = yaganyongImgRepository;
    }

    public List<YaganyongImg> findMoreYaganyongImg(int page, int size) {
        return yaganyongImgRepository.findMoreYaganyongImg(PageRequest.of(page, size));
    }

    public boolean hasNext(int page, int size) {
        long count = yaganyongImgRepository.count();
        return count / size - page > 0;
    }

    public YaganyongImg findTopLikesImg() {
        return yaganyongImgRepository.findTopByOrderByLikesDesc();
    }

    public int incrementLikes(Long changeId) {
        return yaganyongImgRepository.incrementLikes(changeId);
    }
}
