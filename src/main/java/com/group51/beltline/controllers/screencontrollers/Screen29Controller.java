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
public class Screen29Controller {
    @Autowired Screen29viewRepository screen29viewRepository;
    // filter function for screen 29
    @GetMapping(path = "/screen29/filter")
    public @ResponseBody
    Collection<Screen29view> initByManager(@Param("manager") String manager, @Param("startdate") String startdate, @Param("enddate") String enddate, @Param("eve_count_low") String eve_count_low, @Param("eve_count_high") String eve_count_high, @Param("staff_count_low") String staff_count_low, @Param("staff_count_high") String staff_count_high, @Param("total_visit_low") String total_visit_low, @Param("total_visit_high") String total_visit_high, @Param("total_rev_low") String total_rev_low, @Param("total_rev_high") String total_rev_high){
        return screen29viewRepository.filter(manager, startdate, enddate, eve_count_low, eve_count_high, staff_count_low, staff_count_high, total_visit_low, total_visit_high, total_rev_low, total_rev_high);
    }
    
}