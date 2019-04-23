package com.group51.beltline.controllers;

import com.group51.beltline.models.DTO.EmployeeProfile;
import com.group51.beltline.repository.EmployeeProfileRepository;
import com.group51.beltline.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmployeeProfileController {
    @Autowired
    EmployeeProfileRepository employeeProfileRepository;

    @GetMapping(path="/employeeProfile")
    public @ResponseBody
    EmployeeProfile getEmployeeProfile(@Param("username") String username) {
        return employeeProfileRepository.getEmployeeProfile(username);
    }
}
