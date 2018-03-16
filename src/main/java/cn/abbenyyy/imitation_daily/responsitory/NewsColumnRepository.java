package cn.abbenyyy.imitation_daily.responsitory;

import cn.abbenyyy.imitation_daily.domain.NewsColumn;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsColumnRepository extends JpaRepository<NewsColumn,Long>{

    @Query("select n from NewsColumn n order by n.columnId desc ")
    List<NewsColumn> findLimitOneByColumnId(Pageable pageable);
}
