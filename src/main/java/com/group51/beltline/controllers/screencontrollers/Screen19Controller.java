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

@Controller
@RequestMapping
public class Screen19Controller {
    @Autowired
    private SiteRepository siteRepository;

    // filter
    @GetMapping(path = "/screen19/filter")
    public @ResponseBody
    Collection<Site> filter(@Param("Name") String name, @Param("Zipcode") String zipcode, @Param("Address") String address, @Param("OpenEveryday") String openeveryday, @Param("Manager") String manager){
        return siteRepository.filter(name, zipcode, address, openeveryday, manager);
    }

    //delete a site
    @Transactional
    @DeleteMapping(path="/screen19/delete")
    public @ResponseBody
    int deleteSite(@Param("Name") String name){
        return siteRepository.deleteSite(name);
    }
}