package com.group51.beltline.repository;

import com.group51.beltline.models.Transit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface TransitRepository extends JpaRepository<Transit, String> {

    @Query(value = "SELECT * FROM Transit", nativeQuery = true)
    Collection<Transit> getAllTransits();

    // valid a transit by the key
    @Query(value="SELECT COUNT(*) from Transit where Type=?1 AND Route=?2")
    int transitExists(@Param("Type") String type, @Param("Route") String route);

    // select Transit by name
    @Query(value = "SELECT * FROM Transit WHERE Type=?1 AND Route=?2", nativeQuery = true)
    Transit getTransitByKey(@Param("Type") String type, @Param("Route") String route);

    //adds to "Transit" table
    @Modifying //current default for Status is 'Pending'
    @Query(value = "insert into Transit (Type, Route, Price) VALUES (?1,?2,?3)", nativeQuery = true)
    int createNewTransit(@Param("Type") String type, @Param("Route") String route, @Param("Price") Double price);

    //edit a "Transit"
    @Modifying //current default for Status is 'Pending'
    @Query(value = "update Transit set Type=?1, Route=?2, Price=?3 Where Type=?1 AND Route=?2", nativeQuery = true)
    int updateNewTransit(@Param("Type") String type, @Param("Route") String route, @Param("Price") Double price);

    //delete a "Transit"
    @Modifying //current default for Status is 'Pending'
    @Query(value = "delete from Transit Where Type=?1 AND Route=?2", nativeQuery = true)
    int deleteTransit(@Param("Type") String type, @Param("Route") String route);

}