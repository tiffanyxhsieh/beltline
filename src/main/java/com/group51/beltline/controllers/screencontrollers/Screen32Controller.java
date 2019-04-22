
package com.group51.beltline.controllers.screencontrollers;

import com.group51.beltline.models.*;
import com.group51.beltline.models.views.*;
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
public class Screen32Controller {

    @Autowired
    private EventRepository eventRepository;

    @Autowired StaffNameRepository staffNameRepository;

    //Get basic info of an event by key
    // tested
    @GetMapping(path = "/screen32/getBasicInfo") // Map ONLY GET Requests
    public @ResponseBody
    Event getEventByKey(@Param("name") String name, @Param("StartDate") String startdate, @Param("SiteName") String sitename){
        return eventRepository.getEventByKey(name, startdate, sitename);
    }

    // get the duration for an event
    //tested
    @GetMapping(path = "/screen32/getDuration")
    public @ResponseBody
    int getDuration(@Param("name") String name, @Param("StartDate") String startdate, @Param("SiteName") String sitename){
        return eventRepository.getEventDuration(name, startdate, sitename);
    }

    // get staffs assigned to an event
    // select staff assigned to this event
    // tested
    @GetMapping(path = "/screen32/getAssignedStaff")
    public @ResponseBody
    Collection<StaffName> initByManager (@Param("eventname") String eventname, @Param("sitename") String sitename, @Param("startdate") String startdate){
        return staffNameRepository.getAssignedStaff(eventname, sitename, startdate);
    }

}
