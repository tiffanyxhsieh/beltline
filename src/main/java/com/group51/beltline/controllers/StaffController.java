package com.group51.beltline.controllers;

import com.group51.beltline.models.Staff;
import com.group51.beltline.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;

@Controller
@RequestMapping
public class StaffController {
    @Autowired
    StaffRepository staffRepository;

    //get all staff
    @GetMapping(path="/staff")
    public @ResponseBody
    Collection<Staff> getAllStaff(){
        return staffRepository.getAllStaff();
    }

    @Transactional
    @PostMapping(path="/staff")
    public @ResponseBody
    int createNewUser(@RequestHeader("username") String username) {
        return staffRepository.addStaff(username);
    }
}
