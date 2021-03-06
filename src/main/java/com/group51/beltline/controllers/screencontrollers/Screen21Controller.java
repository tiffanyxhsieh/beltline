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
public class Screen21Controller {
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private UserRepository userRepository;


    // get unsigned managers
    //tested
    @GetMapping(path="/screen21/findavemanagers")
    public @ResponseBody
            Collection<StaffName> getUnassignedManage(){
        return siteRepository.getUnassignedManagers();
    }
    
    // get username by first and last name
    // Tested
    @GetMapping(path="/screen21/findusersbyname")
    public @ResponseBody
    Collection<User> getOneUserByName(@Param("firstname") String firstname, @Param("lastname") String lastname) {
        return userRepository.getOneUserByName(firstname, lastname);
    }

    //create a site
    // tesetd
    @Transactional
    @PostMapping(path="/screen21/create")
    public @ResponseBody
    int createNewsite(@Param("Name") String name, @Param("Zipcode") String zipcode, @Param("Address") String address, @Param("OpenEveryday") String openeveryday, @Param("Manager") String manager){
        return siteRepository.createNewSite(name, zipcode, address, openeveryday, manager);
    }
}