package com.group51.beltline.controllers;

import com.group51.beltline.models.*;
import com.group51.beltline.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    //Get ALL events
    @GetMapping(path = "/events")
    public @ResponseBody
    Collection<Event> getEvents(){
        return eventRepository.getAllEvents();
    }
//   Name varchar(50) NOT NULL,
//   StartDate date NOT NULL,
//   SiteName varchar(50) NOT NULL,
//   EndDate date NOT NULL,
//   Price decimal(5,2) NOT NULL,
//   Capacity int NOT NULL,
//   MinStaffReq int NOT NULL DEFAULT '1',
//   Description TEXT NOT NULL,

    //Get events by name
    @GetMapping(path = "/event") // Map ONLY GET Requests
    public @ResponseBody
    Event getEventByName(@Param(value="name") String name){
        return eventRepository.getEventByName(name);
    }

    //create a event
    // localhost:8080/event?name=Official Atlanta BeltLine Bike Tour&startDate=2019-02-09&siteName=Inman Park&endDate=2019-02-09&price=1&capacity=1&minStaffReq=1&description=1
    @Transactional
    @PostMapping(path="/event")
    public @ResponseBody
    int createNewEvent(@Param("Name") String name, @Param("StartDate") String startdate, @Param("SiteName") String sitename, @Param("EndDate") String enddate, @Param("Price") Double price, @Param("Capacity") Integer capacity, @Param("MinStaffReq") Integer minstaffreq, @Param("Description") String description){
        return eventRepository.createNewEvent(name, startdate, sitename, enddate, price, capacity, minstaffreq, description);
    }

    //update a events
    @Transactional
    @PutMapping(path="/event")
    public @ResponseBody
    int putNewEvent(@Param("Name") String name, @Param("StartDate") String startdate, @Param("SiteName") String sitename, @Param("EndDate") String enddate, @Param("Price") Double price, @Param("Capacity") Integer capacity, @Param("MinStaffReq") Integer minstaffreq, @Param("Description") String description){
        // return eventRepository.updateNewEventTest(name, startDate);
        return eventRepository.updateNewEvent(name, startdate, sitename, enddate, price, capacity, minstaffreq, description);
    }

    //delete a events
    @Transactional
    @DeleteMapping(path="/event")
    public @ResponseBody
    int deleteEvent(@Param("Name") String name){
        return eventRepository.deleteEvent(name);
    }
}