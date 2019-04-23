package com.group51.beltline.controllers;

import com.group51.beltline.models.DTO.ManageUser;
import com.group51.beltline.models.DTO.TransitHistory;
import com.group51.beltline.repository.ManageUserRepository;
import com.group51.beltline.repository.TransitHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping

public class ManageUserController {
    @Autowired
    private ManageUserRepository manageUserRepository;

    @GetMapping(path="/screen18/filter")
    public @ResponseBody
    Collection<ManageUser> filterManagedUsers(@Param("username") String username, @Param("status") String status, @Param("usertype") String usertype){
        return manageUserRepository.manageUserFilter(username, status, usertype);
    }


    @GetMapping(path="/screen18/filter")
    public @ResponseBody
    Collection<ManageUser> filterManagedUsers(@Param("username") String username, @Param("status") String status, @Param("usertype") String usertype){
        return manageUserRepository.manageUserFilter(username, status, usertype);
    }




}
