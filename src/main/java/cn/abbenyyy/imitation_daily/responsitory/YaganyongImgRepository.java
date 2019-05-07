package cn.abbenyyy.imitation_daily.responsitory;

import cn.abbenyyy.imitation_daily.domain.YaganyongImg;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 协会的数据库读写接口
 */
public interface YaganyongImgRepository extends JpaRepository<YaganyongImg, Long> {

    @Query("select y from YaganyongImg y order by y.createTime desc")
    List<YaganyongImg> findMoreYaganyongImg(Pageable pageable);

    YaganyongImg findTopByOrderByLikesDesc();

    @Transactional
    @Modifying
    @Query("update YaganyongImg y set y.likes = y.likes + 1 where y.id=?1")
    int incrementLikes(Long changeId);
}
