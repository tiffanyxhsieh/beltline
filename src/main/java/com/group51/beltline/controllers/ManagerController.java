package com.group51.beltline.controllers;

import com.group51.beltline.models.Manager;
import com.group51.beltline.repository.EmployeeRepository;
import com.group51.beltline.repository.ManagerRepository;
import com.group51.beltline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;

@Controller
@RequestMapping
public class ManagerController {
    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EmployeeRepository employeeRepository;


    //get all managers
    @GetMapping(path="/managers")
    public @ResponseBody
    Collection<Manager> getAllManagers(){
        return managerRepository.getAllManagers();
    }

    @Transactional
    @PostMapping(path="/managers")
    public @ResponseBody
    int createNewManager(@RequestHeader("username") String username
    ){
        return managerRepository.addManager(username);
    }



}
