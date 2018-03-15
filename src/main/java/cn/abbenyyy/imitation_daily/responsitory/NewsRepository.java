package cn.abbenyyy.imitation_daily.responsitory;

import cn.abbenyyy.imitation_daily.domain.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

    @Query(value = "SELECT news.id,news.title,news.description,news.praise_count,news.comment_count,news.create_time,news.img_url," +
            "news.css_column,news.appview,news_category.category_name FROM db_imitationdaily.news,db_imitationdaily.news_category " +
            "where db_imitationdaily.news.news_category_id = db_imitationdaily.news_category.category_id order by news.create_time " +
            "ASC limit :page,:pageSize",
            nativeQuery = true)
    List<Object[]> findByNativeSQL(@Param("page") int page, @Param("pageSize") int pageSize);

    @Query("select n from News n where n.cssColumn =:cssColumn order by n.createTime desc")
    List<News> findByCssColumn(@Param("cssColumn") long cssColumn, Pageable pageable);

    @Query("select n from News n where n.newsCategory.categoryId > 2 order by n.createTime desc ")
    List<News> findByMore(Pageable pageable);
}
