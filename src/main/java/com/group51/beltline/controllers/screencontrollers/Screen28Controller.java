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
public class Screen28Controller {

    @Autowired
    private Manage_staffRepository manage_staffRepository;

    @Autowired
    private SiteRepository siteRepository;

    //TODO: add getSItes by manager
    @GetMapping(path = "/screen28/getSitesByManger")
    public @ResponseBody
    Collection<Site> getSitesByManger(@Param("manager") String manager){
        return siteRepository.getAllSitesByManager(manager);
    }

    // filter
    // tested
    @GetMapping(path = "/screen28/filter")
    public @ResponseBody
    Collection<Manage_staff> initByManager(@Param("startdate") String startdate, 
    @Param("enddate") String enddate,
    @Param("sitename") String sitename){
        return manage_staffRepository.filter(startdate, enddate, sitename);
    }

    // @GetMapping(path = "/screen28/filter")
    // public @ResponseBody
    // Collection<Manage_staff> initByManager(@Param("startdate") String startdate, 
    // @Param("enddate") String enddate){
    //     return manage_staffRepository.filter(startdate, enddate);
    // }

}