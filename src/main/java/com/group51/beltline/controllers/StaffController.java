package com.group51.beltline.controllers;

import com.group51.beltline.models.Staff;
import com.group51.beltline.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
