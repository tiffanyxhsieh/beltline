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
public class VisitSiteController {

    @Autowired
    private VisitSiteRepository visitSiteRepository;
   
    //Get ALL visit_sites
    @GetMapping(path = "/visit_sites")
    public @ResponseBody
    Collection<Visit_Site> getVisitSites(){
        return visitSiteRepository.getAllVisitSites();
    }

    //create a site
    @Transactional
    @PostMapping(path="/visit_site")
    public @ResponseBody
    int createNewVistSite(@Param("Username") String username, @Param("SiteName") String sitename, @Param("Date") String date){
        return visitSiteRepository.createNewVisitSite(username, sitename, date);
    }

}