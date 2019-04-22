package com.group51.beltline.repository;

import com.group51.beltline.models.AssignTo;
import com.group51.beltline.models.Visit_Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface AssignToRepository extends JpaRepository<AssignTo, String> {

    @Query(value = "SELECT * FROM Assign_to", nativeQuery = true)
    Collection<AssignTo> getAllAssignTos();

    //adds to "Take" table
    @Modifying //current default for Status is 'Pending'
    @Query(value = "insert into Assign_to (Username, Name, StartDate, SiteName) VALUES (?1,?2,?3,?4)", nativeQuery = true)
    int createNewAssignTo(@Param("Username") String Username, @Param("Name") String Name, @Param("StartDate") String StartDate, @Param("SiteName") String SiteName);

    // deletes assignTo
     @Modifying 
     @Query(value = "delete from Assign_to where SiteName=?1 AND StartDate=?2 AND Name=?3 AND Username=?4", nativeQuery = true)
     int deleteAssignTos(@Param("SiteName") String sitename, @Param("StartDate") String startdate, @Param("Name") String name, @Param("Username") String username);

}