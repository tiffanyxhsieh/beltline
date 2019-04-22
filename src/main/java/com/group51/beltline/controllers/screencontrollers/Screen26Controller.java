package com.group51.beltline.controllers.screencontrollers;

import com.group51.beltline.models.*;
import com.group51.beltline.models.views.ManageEvent26;
import com.group51.beltline.models.views.Manage_event;
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
public class Screen26Controller {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AssignToRepository assignToRepository;

    @Autowired
    private ManageEvent26Repository manageEvent26Repository;

    @Autowired
    private StaffNameRepository staffNameRepository;

    // update description of an event
    @Transactional
    @PutMapping(path = "/screen26/updateDes")
    public @ResponseBody int updateDes(@Param("Description") String description, @Param("Name") String name,
            @Param("StartDate") String startdate, @Param("SiteName") String sitename) {
        // return eventRepository.updateNewEventTest(name, startDate);
        return eventRepository.updateEventDes(description, name, startdate, sitename);
    }

    // select staff assigned to this event
    
    @GetMapping(path = "/screen26/getAssignedStaff")
    public @ResponseBody
    Collection<StaffName> initByManager (@Param("eventname") String eventname, @Param("sitename") String sitename, @Param("startdate") String startdate){
        return staffNameRepository.getAssignedStaff(eventname, sitename, startdate);
    }

    // select staff which is available
    @GetMapping(path = "/screen26/getAvailableStaff")
    public @ResponseBody
    Collection<StaffName> initByManager(@Param("start_date") String start_date, @Param("end_date") String end_date){
        return staffNameRepository.getAvStaff(start_date, end_date);
    }

    // delete staffs assigned to this event
    @Transactional
    @DeleteMapping(path="/screen25/deleteStaffs")
    public @ResponseBody
    int deleteAssignTos(@Param("SiteName") String sitename, @Param("StartDate") String startdate, @Param("Name") String name, @Param("Username") String username){
        return assignToRepository.deleteAssignTos(sitename, startdate, name, username);
    }

    // create staff assign to
    //create a assignto
    @Transactional
    @PostMapping(path="/screen26/createAssignTo")
    public @ResponseBody
    int createNewTake(@Param("Username") String username, @Param("Name") String name, @Param("StartDate") String startdate, @Param("SiteName") String sitename){
        return assignToRepository.createNewAssignTo(username, name, startdate, sitename);
    }

    // filter function
    // Tested
    @GetMapping(path = "/screen26/filter")
    public @ResponseBody Collection<ManageEvent26> filter(@Param("Name") String name,
            @Param("StartDate") String startdate, @Param("SiteName") String sitename,
            @Param("lowdailyvisits") String lowdailyvisits, @Param("highdailyvisits") String highdailyvisits,
            @Param("lowdailyrevenue") String lowdailyrevenue, @Param("highdailyrevenue") String highdailyrevenue) {
        return manageEvent26Repository.filter(name, startdate, sitename, lowdailyvisits, highdailyvisits, lowdailyrevenue, highdailyrevenue);
    }


}