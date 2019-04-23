package com.group51.beltline.repository;

import com.group51.beltline.models.DTO.TransitHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface TransitHistoryRepository extends JpaRepository<TransitHistory, String> {
//GET List<TransitHistory> getTransitHistory(username, type, site, route, startDate, endDate)
    //TODO: fix this....filter isn't going by username
    @Query(value="Select * from take_transit where " +
            "username=?1 AND " +
            "(?2 IS NULL OR ?2='' or `type`=?2) AND " +
            "(?3 IS NULL OR ?3='' or route=?3) AND " +
            "date BETWEEN ?4 and ?5", nativeQuery=true)
    Collection<TransitHistory> getUserTransitHistory(@Param("username")String username,
                                                     @Param("type")String type,
                                                     @Param("route") String route,
                                                     @Param("start") String start,
                                                     @Param("end") String end);

}
