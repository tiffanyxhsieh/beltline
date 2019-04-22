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

@Controller
@RequestMapping
public class Screen26Controller {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private AssignToRepository assignToRepository;

    @Autowired
    private ManageEvent26Repository manageEvent26Repository;

    // update description of an event
    @Transactional
    @PutMapping(path = "/screen26/updateDes")
    public @ResponseBody int putNewEvent(@Param("Description") String description, @Param("Name") String name,
            @Param("StartDate") String startdate, @Param("SiteName") String sitename) {
        // return eventRepository.updateNewEventTest(name, startDate);
        return eventRepository.updateEventDes(description, name, startdate, sitename);
    }

    // select staff assigned to this event

    // select staff which is available

    // delete staff

    // create staff assign to

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