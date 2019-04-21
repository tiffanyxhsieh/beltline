package com.group51.beltline.repository;

import com.group51.beltline.models.DTO.take_transit;
import com.group51.beltline.models.Take;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface Take_TransitRepository extends JpaRepository<take_transit, String> {
    //TODO: different queries for when type, route, date are empty

    @Query(value ="SELECT * FROM take_transit " +
            "where (?1 IS NULL OR type=?1) " +
            "AND (?2 IS NULL OR route=?2) " +
            "AND date BETWEEN ?3 and ?4 "
            ,
             nativeQuery = true)
    Collection<take_transit> gettake_transitBy(
                                                @Param("type")String type,
                                                @Param("route") String route,
                                                @Param("start") String start,
                                                @Param("end") String end);


}
