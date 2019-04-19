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
public class SiteController {
    @Autowired
    private SiteRepository siteRepository;

    //Get ALL Site
    @GetMapping(path = "/sites")
    public @ResponseBody
    Collection<Site> getSites(){
        return siteRepository.getAllSites();
    }

    //Get site by name
    @GetMapping(path = "/site") // Map ONLY GET Requests
    public @ResponseBody
    Site getUserByName(@Param(value="name") String name){
        return siteRepository.getUserByName(name);
    }

    //create a site
    @Transactional
    @PostMapping(path="/site")
    public @ResponseBody
    int createNewsite(@Param("Name") String name, @Param("Zipcode") String zipcode, @Param("Address") String address, @Param("OpenEveryday") String openEveryday, @Param("Manager") String manager){
        return siteRepository.createNewSite(name, zipcode, address, openEveryday, manager);
    }

    //update a site
    @Transactional
    @PutMapping(path="/site")
    public @ResponseBody
    int putNewsite(@Param("Name") String name, @Param("Zipcode") String zipcode, @Param("Address") String address, @Param("OpenEveryday") String openEveryday, @Param("Manager") String manager){
        return siteRepository.updateNewSite(name, zipcode, address, openEveryday, manager);
    }

    //delete a site
    @Transactional
    @DeleteMapping(path="/site")
    public @ResponseBody
    int deleteSite(@Param("Name") String name){
        return siteRepository.deleteSite(name);
    }
}