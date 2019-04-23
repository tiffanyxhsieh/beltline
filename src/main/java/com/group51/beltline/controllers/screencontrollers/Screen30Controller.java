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
public class Screen30Controller {

    @Autowired
    private Daily_detailRepository daily_detailRepository;

    @Autowired
    private StaffNameRepository staffNameRepository;

    // get daily_details (but did not include staff assigned)
    
    @GetMapping(path = "/screen30/getDailyDetail")
    public @ResponseBody
    Collection<Daily_detail> initByManager(@Param("username") String username){
        return daily_detailRepository.getDailyDetails(username);
    }
    
   // select staff assigned to this event
    // tested
    @GetMapping(path = "/screen26/getAssignedStaff")
    public @ResponseBody
    Collection<StaffName> initByManager (@Param("eventname") String eventname, @Param("sitename") String sitename, @Param("startdate") String startdate){
        return staffNameRepository.getAssignedStaff(eventname, sitename, startdate);
    }



}