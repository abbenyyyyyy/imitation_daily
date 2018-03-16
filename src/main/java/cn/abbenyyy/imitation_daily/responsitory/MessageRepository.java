package cn.abbenyyy.imitation_daily.responsitory;

import cn.abbenyyy.imitation_daily.domain.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long>{

    @Query("select m from Message m where m.statusId =:status_id order by m.createTime desc")
    List<Message> findStatusIdLLL(@Param("status_id") long statusId, Pageable pageable);
}
