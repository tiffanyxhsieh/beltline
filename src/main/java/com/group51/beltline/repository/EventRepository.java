package com.group51.beltline.repository;

import com.group51.beltline.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface EventRepository extends JpaRepository<Event, String> {

    @Query(value = "SELECT * FROM Event", nativeQuery = true)
    Collection<Event> getAllEvents();

    // validate an event by key
    @Query(value="SELECT COUNT(*) from Event where Name=?1 AND StartDate=?2 AND SiteName=?3")
    int eventExists(@Param("name") String name, @Param("StartDate") String startdate, @Param("SiteName") String sitename);

    // select Event by name
    @Query(value = "SELECT * FROM Event WHERE Name=?1", nativeQuery = true)
    Event getEventByName(@Param("name") String name);

    // select Event by key
     //SiteName, StartDate, Name
    @Query(value = "SELECT * FROM Event WHERE Name=?1 AND StartDate=?2 AND SiteName=?3", nativeQuery = true)
    Event getEventByKey(@Param("name") String name, @Param("StartDate") String startdate, @Param("SiteName") String sitename);

    //adds to "Event" table
    @Modifying //current default for Status is 'Pending'
    @Query(value = "insert into Event (Name, StartDate, SiteName, EndDate, Price, Capacity, MinStaffReq, Description) VALUES (?1,?2,?3, ?4,?5, ?6, ?7, ?8)", nativeQuery = true)
    int createNewEvent(@Param("Name") String name, @Param("StartDate") String startDate, @Param("SiteName") String siteName, @Param("EndDate") String endDate, @Param("Price") Double price, @Param("Capacity") Integer capacity, @Param("MinStaffReq") Integer minStaffReq, @Param("Description") String description);

    //edit a "Event"
    @Modifying //current default for Status is 'Pending'
    @Query(value = "update Event set Name=?1, StartDate=?2, SiteName=?3, EndDate=?4, Price=?5, Capacity=?6, MinStaffReq=?7, Description=?8 Where Name=?1", nativeQuery = true)
    int updateNewEvent(@Param("Name") String name, @Param("StartDate") String startDate, @Param("SiteName") String siteName, @Param("EndDate") String endDate, @Param("Price") Double price, @Param("Capacity") Integer capacity, @Param("MinStaffReq") Integer minStaffReq, @Param("Description") String description);

    // need to test
    //edit a event description using its key
    @Modifying //current default for Status is 'Pending'
    @Query(value = "update Event set Description=?1 Where Name=?2 AND StartDate=?3 AND SiteName=?4", nativeQuery = true)
    int updateEventDes(@Param("Description") String description, @Param("Name") String name, @Param("StartDate") String startdate, @Param("SiteName") String sitename);

    //delete a "Event"
    @Modifying //current default for Status is 'Pending'
    @Query(value = "delete from Event Where Name=?1", nativeQuery = true)
    int deleteEvent(@Param("Name") String Name);

     // get staff assign to an event by using event key
     @Query(value = "SELECT DISTINCT * FROM assign_to AS a JOIN user AS u ON a.username = u.username", nativeQuery = true)
     Collection<User> getStaffForEvent(@Param("Name") String name, @Param("StartDate") String startdate, @Param("SiteName") String sitename);

}