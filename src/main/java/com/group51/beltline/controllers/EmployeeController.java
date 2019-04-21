package com.group51.beltline.controllers;

import com.group51.beltline.models.Employee;
import com.group51.beltline.repository.EmployeeRepository;
import com.group51.beltline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;

@Controller
@RequestMapping
public class EmployeeController {
    static int employeeId = 40;

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    UserRepository userRepository;

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
                          @RequestHeader("firstName") String firstName,
                          @RequestHeader("lastName") String lastName,
                          @RequestHeader("password") String password,
                          @RequestHeader("phone") long phone,
                          @RequestHeader("address") String address,
                          @RequestHeader("city") String city,
                          @RequestHeader("state") String state,
                          @RequestHeader("zipcode") int zipcode
    ) {
        userRepository.createNewUser(firstName, lastName, username, password);
        employeeId++;
        return employeeRepository
                .createNewEmployee(username, employeeId, phone, address, city, state, zipcode);
    }

    @Transactional
    @PutMapping(path="/screen17/update")
    public @ResponseBody
    int updateEmployee(@Param("firstName") String firstName,
                       @Param("lastName") String lastName,
                       @Param("phone") String phone,
                       @Param("username") String username) {

        int val = 0;

        if (firstName != null) {
            val = employeeRepository.updateEmployeeFirstName(firstName, username);
        }
        if (lastName != null) {
            val =employeeRepository.updateEmployeeLastName(lastName, username);
        }

        if (phone != null) {
            val = employeeRepository.updateEmployeePhone(phone, username);
        }
        return val;


    }
}
