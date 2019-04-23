package com.group51.beltline.repository;

import com.group51.beltline.models.DTO.VisitorHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface VisitorHistoryRepository extends JpaRepository<VisitorHistory, String> {

    @Query(value="SELECT * from visit_history where username=?1 AND " +
            "(?2 IS NULL OR event_name=?2) AND " +
            "(?3 IS NULL OR sitename=?3) AND " +
            "date BETWEEN ?4 and ?5", nativeQuery = true
            )
    Collection<VisitorHistory> getVisitorHistory(@Param("username") String username,
                                                 @Param("event_name") String event_name,
                                                 @Param("sitename") String sitename,
                                                 @Param("start") String start,
                                                 @Param("end") String end
                                     );
}
