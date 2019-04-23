package com.group51.beltline.repository;

import com.group51.beltline.models.Connect;
import com.group51.beltline.models.views.Manage_transit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface Manage_transitRepository extends JpaRepository<Manage_transit, String> {

    @Query(value = "SELECT * FROM manage_transit where (?1 IS NULL OR type like CONCAT('%', ?1, '%')) AND (?2 is null or route like CONCAT('%', ?2, '%') AND (?3 is null or sitename like CONCAT('%', ?3, '%')) AND (?4 is null or ?4 <= price) AND (?5 is null or ?5 >=price))", nativeQuery = true)
    Collection<Manage_transit> getAllManageTransit(@Param("type") String type, @Param("route") String route, @Param("sitename") String sitename, @Param("price_low") String price_low, @Param("price_high") String price_high);
 
}