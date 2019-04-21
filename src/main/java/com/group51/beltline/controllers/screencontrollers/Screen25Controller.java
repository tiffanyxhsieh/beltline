package com.group51.beltline.controllers.screencontrollers;

import com.group51.beltline.models.*;
import com.group51.beltline.models.views.Manage_event;
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
public class Screen25Controller {
    @Autowired
    private Manage_eventRepository manage_eventRepository;

    @Autowired
    private EventRepository eventRepository;

    //  // get all event
    //  @GetMapping(path = "/screen25/all")
    //  public @ResponseBody
    //  Collection<Manage_event> all(){
    //      return manage_eventRepository.getAllManageEvent();
    //  }

    // initialize the event managed by a manager
    @GetMapping(path = "/screen25/eventbymanager")
    public @ResponseBody
    Collection<Manage_event> initByManager(@Param("manager") String manager){
        return manage_eventRepository.getManageEventByManager(manager);
    }

    //filter // need to do test
    @GetMapping(path = "/screen25/filter")
    public @ResponseBody
    Collection<Manage_event> filter(@Param("manager") String manager, 
                                    @Param("name") String name,
                                    @Param("keyword") String keyword,
                                    @Param("start_date") String start_date,
                                    @Param("end_date") String end_date,
                                    @Param("dur_low") String dur_low,
                                    @Param("dur_high") String dur_high,
                                    @Param("total_visit_low") String total_visit_low,
                                    @Param("total_visit_high") String total_visit_high,
                                    @Param("total_rev_low") String total_rev_low,
                                    @Param("total_rev_high") String total_rev_high){
        return manage_eventRepository.filter(manager, name, keyword, start_date, end_date, dur_low, dur_high, total_visit_low, total_visit_high, total_rev_low, total_rev_high);
    }

    // delete a event
     @Transactional
     @DeleteMapping(path="/screen25/deleteEvent")
     public @ResponseBody
     int deleteEvent(@Param("Name") String name){
         return eventRepository.deleteEvent(name);
     }
}