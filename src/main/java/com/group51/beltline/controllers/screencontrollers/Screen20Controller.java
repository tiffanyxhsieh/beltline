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
public class Screen20Controller {
    @Autowired
    private SiteRepository siteRepository;

    // select a signle site

    //update a site 
    @Transactional
    @PutMapping(path="/screen20/update")
    public @ResponseBody
    int putNewsite(@Param("Name") String name, @Param("Zipcode") String zipcode, @Param("Address") String address, @Param("OpenEveryday") String openeveryday, @Param("Manager") String manager){
        return siteRepository.updateNewSite(name, zipcode, address, openeveryday, manager);
    }
}