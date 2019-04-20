package com.group51.beltline;

import com.group51.beltline.models.*;
import com.group51.beltline.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;

@ComponentScan
@Controller
@RequestMapping
public class RESTController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ManagerRepository managerRepository;




    //Check login credentials
    @GetMapping(path="/login")
    public @ResponseBody
    boolean checkLogin(@RequestHeader(value="username") String username, @RequestHeader(value="password") String password) {
        if(userRepository.checkLogin(username, password) != null) {
            return true;
        }

        return false;
    }








//
//    @GetMapping(path="/visitors")
//    public @ResponseBody
//    Collection<Visitor> getAllVisitors(){
//        return visitorRepository.getAllVisitors();
//    }





}
