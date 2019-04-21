package com.group51.beltline.controllers.screencontrollers;

import com.group51.beltline.models.*;
import com.group51.beltline.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

// need to test
@Controller
@RequestMapping
public class Screen27Controller {
    @Controller
    @RequestMapping
    public class TransitController {
        @Autowired
        private EventRepository eventRepository;
        @Autowired
        private AssignToRepository assignToRepository;
       
        //create a event
        @Transactional
        @PostMapping(path="/screen27/createEvent")
        public @ResponseBody
        int createNewEvent(@Param("Name") String name, @Param("StartDate") String startdate, @Param("SiteName") String sitename, @Param("EndDate") String enddate, @Param("Price") Double price, @Param("Capacity") Integer capacity, @Param("MinStaffReq") Integer minstaffreq, @Param("Description") String description){
            return eventRepository.createNewEvent(name, startdate, sitename, enddate, price, capacity, minstaffreq, description);
        }

        //create a assignto
        @Transactional
        @PostMapping(path="/screen27/createAssignTo")
        public @ResponseBody
        int createNewTake(@Param("Username") String username, @Param("Name") String name, @Param("StartDate") String startdate, @Param("SiteName") String sitename){
            return assignToRepository.createNewAssignTo(username, name, startdate, sitename);
        }
    }
}