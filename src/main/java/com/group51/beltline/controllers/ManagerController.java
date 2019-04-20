package com.group51.beltline.controllers;

import com.group51.beltline.models.Manager;
import com.group51.beltline.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping
public class ManagerController {
    @Autowired
    ManagerRepository managerRepository;


    //get all managers
    @GetMapping(path="/managers")
    public @ResponseBody
    Collection<Manager> getAllManagers(){
        return managerRepository.getAllManagers();
    }



}
