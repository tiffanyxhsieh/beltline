package com.group51.beltline.repository;

import com.group51.beltline.models.DTO.take_transit;
import com.group51.beltline.models.DTO.take_transit1;
import com.group51.beltline.models.Take;
import com.group51.beltline.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface Take_TransitRepository extends JpaRepository<take_transit, String> {
    //TODO: Fix Like Query....still only doing exact match


    @Query(value ="select transit.route , transit.type, price, count(*) as 'ConnectedSites' " +
            "from transit join connect on transit.type = connect.type and transit.route = connect.route " +
            "group by type, route "+
            "having transit.route in (select route "+
            "from connect "+
            "where (?1 IS NULL or sitename=?1)) "+
            "and transit.type in (select type "+
            "from transit "+
            "where (?2 Is NULL or type=?2) and price between ?3 and ?4)"
            ,
            nativeQuery = true)
    Collection<take_transit>filterTake_transitBy(
                                                @Param("site")String site,
                                                @Param("type") String type,
                                                @Param("low") String low,
                                                @Param("high") String high);


    @Modifying
    @Query(value="CREATE VIEW take_transit AS "+
            "SELECT tk.date,tk.route,tk.type,tr.price FROM connect as cn "+
            "join transit as tr on cn.type = tr.type AND cn.route = tr.route "+
            "join take as tk on tr.type = tk.type AND tr.route = tk.route "+
            "where tk.username = ?1 "+
            "GROUP BY tr.type,tr.route" , nativeQuery=true)
    void loadUserTake_Transit(@Param("username") String username);

    @Query(value="SELECT * FROM take_transit WHERE date BETWEEN $startdate AND $enddate " +
            "AND WHERE (?1 IS NULL OR route LIKE CONCAT(?1,'%')) " +
            "AND WHERE (?3 IS NULL OR type LIKE CONCAT(?3,'%') " +
            "AND type = $type AND price = $price " +
            "AND (type,route) in (select type,route from connect where sitename = $containsite)", nativeQuery = true)
    Collection<take_transit> getUserTake_TransitFilter(
            @Param("route") String route,
            @Param("site")String site,
            @Param("type") String type,
            @Param("low") String low,
            @Param("high") String high);


}
