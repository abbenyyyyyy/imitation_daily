package cn.abbenyyy.imitation_daily.responsitory;

import cn.abbenyyy.imitation_daily.domain.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    @Query("select n from News n where n.cssColumn =:cssColumn order by n.createTime desc")
    List<News> findByCssColumn(@Param("cssColumn") long cssColumn, Pageable pageable);

    @Query("select n from News n where n.newsCategory.categoryId > 2 order by n.createTime desc")
    List<News> findMore(Pageable pageable);

    @Query("select n from News n where n.newsCategory.categoryId <= 2 order by n.createTime desc")
    List<News> findCategoryIdLessThen2(Pageable pageable);

    @Query("select n from News n where n.createTime < " +
            "(select l.createTime from  News l where l.id =:lastKey) order by n.createTime desc")
    List<News> findMoreAfter(@Param("lastKey") long lastKey,Pageable pageable);
}
