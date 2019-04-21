package com.group51.beltline.repository;

import com.group51.beltline.models.DTO.take_transit;
import com.group51.beltline.models.Take;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface Take_TransitRepository extends JpaRepository<take_transit, String> {
    //TODO: Fix Like Query....still only doing exact match

    @Query(value ="	select transit.route , transit.type, price, count(*) " +
            "from transit join connect on transit.type = connect.type and transit.route = connect.route " +
            "group by type, route "+
            "having transit.route in (select route "+
            "from connect "+
            "where sitename = ?1) "+
            "and transit.type in (select type "+
            "from transit "+
            "where type like ?2% and price between ?3 and ?4 )"
            ,
             nativeQuery = true)
    Collection<take_transit> filterTake_transitBy(
                                                @Param("site")String site,
                                                @Param("type") String type,
                                                @Param("low") String low,
                                                @Param("high") String high);


}
