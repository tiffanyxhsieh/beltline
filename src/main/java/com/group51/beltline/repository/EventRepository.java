package com.group51.beltline.repository;

import com.group51.beltline.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface EventRepository extends JpaRepository<Event, String> {

    @Query(value = "SELECT * FROM Event", nativeQuery = true)
    Collection<Event> getAllEvents();

    // select site by name
    @Query(value = "SELECT * FROM Event WHERE Name=?1", nativeQuery = true)
    Event getEventByName(@Param("name") String name);

    //adds to "Site" table
    @Modifying //current default for Status is 'Pending'
    @Query(value = "insert into Event (Name, StartDate, SiteName, EndDate, Price, Capacity, MinStaffReq, Description) VALUES (?1,?2,?3, ?4,?5, ?6, ?7, ?8)", nativeQuery = true)
    int createNewEvent(@Param("Name") String name, @Param("StartDate") String startDate, @Param("SiteName") String siteName, @Param("EndDate") String endDate, @Param("Price") Double price, @Param("Capacity") Integer capacity, @Param("MinStaffReq") Integer minStaffReq, @Param("Description") String description);

    //edit a "Site"
    @Modifying //current default for Status is 'Pending'
    @Query(value = "update Event set Name=?1, StartDate=?2, SiteName=?3, EndDate=?4, Price=?5, Capacity=?6, MinStaffReq=?7, Description=?8 Where Name=?1", nativeQuery = true)
    int updateNewEvent(@Param("Name") String name, @Param("StartDate") String startDate, @Param("SiteName") String siteName, @Param("EndDate") String endDate, @Param("Price") Double price, @Param("Capacity") Integer capacity, @Param("MinStaffReq") Integer minStaffReq, @Param("Description") String description);

    //delete a "Site"
    @Modifying //current default for Status is 'Pending'
    @Query(value = "delete from Event Where Name=?1", nativeQuery = true)
    int deleteEvent(@Param("Name") String Name);

}