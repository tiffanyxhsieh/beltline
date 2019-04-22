package com.group51.beltline.repository;

import com.group51.beltline.models.Connect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ConnectRepository extends JpaRepository<Connect, String> {

    @Query(value = "SELECT * FROM Connect", nativeQuery = true)
    Collection<Connect> getAllConnects();

     //adds to "connect" table
     @Modifying 
     @Query(value = "insert into Connect (SiteName, Type, Route) VALUES (?1,?2,?3)", nativeQuery = true)
     int createNewConnect(@Param("SiteName") String SiteName, @Param("Type") String Type, @Param("Route") String Route);

     //delete a connect
     // need to test
     @Modifying 
     @Query(value = "delete from Connect where SiteName=?1", nativeQuery = true)
     int deleteConnects(@Param("SiteName") String SiteName);
 
}