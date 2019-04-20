package com.group51.beltline.controllers;

import com.group51.beltline.models.Employee;
import com.group51.beltline.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;

@Controller
@RequestMapping
public class EmployeeController {
    static int employeeId = 30;

    @Autowired
    EmployeeRepository employeeRepository;

    //gets all employee usernames
    @GetMapping(path="/employees")
    public @ResponseBody
    Collection<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }


    //create new employee
    @Transactional
    @PostMapping(path="/employees")
    public @ResponseBody
    int createNewEmployee(@RequestHeader("username") String username,
                          @RequestHeader("phone") int phone,
                          @RequestHeader("address") String address,
                          @RequestHeader("city") String city,
                          @RequestHeader("state") String state,
                          @RequestHeader("zipcode") int zipcode
    ) {

        employeeId++;
        return employeeRepository
                .createNewEmployee(username, employeeId, phone, address, city, state, zipcode);
    }
}
