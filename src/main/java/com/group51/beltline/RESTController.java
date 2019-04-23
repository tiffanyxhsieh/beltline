package com.group51.beltline;

import com.group51.beltline.models.*;
import com.group51.beltline.models.DTO.take_transit;
import com.group51.beltline.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Modifying;
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
    private VisitorRepository visitorRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private Take_TransitRepository take_transitRepository;




    //Check login credentials
    @GetMapping(path="/login")
    public @ResponseBody
    int checkLogin(@RequestHeader(value="email") String email, @RequestHeader(value="password") String password) {
            return userRepository.checkLogin(email, password);
// if(userRepository.checkLogin(email, password) != null) {
//            return true;
//        }
//
//        return false;
    }

    @GetMapping(path="/manageUser")
    public @ResponseBody
    void showManageUserPage() {

    }



    @Transactional
    @PostMapping(path="/visitors")
    public @ResponseBody
    int addVisitor(@RequestHeader("username") String username) {
        return visitorRepository.addVisitor(username);
    }



    //get all visitors
    @GetMapping(path="/visitors")
    public @ResponseBody
    Collection<Visitor> getAllVisitors(){
        return visitorRepository.getAllVisitors();
    }



    @Transactional
    @PostMapping(path="/screen38/log")
    public @ResponseBody
    int logSiteVisit(@Param("username") String username,
                     @Param("site_name") String site_name,
                     @Param("date_log") String date_log) {
        return userRepository.logVisit(username, site_name, date_log);
    }


//    @GetMapping(path="/screen38/log")
//    public @ResponseBody
//    int logExists(@Param("username") String username, @Param("site")){
//        return userRepository.logVisit();
//    }

}
