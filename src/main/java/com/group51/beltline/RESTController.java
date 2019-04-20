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

    static int employeeId = 20;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdministratorRepository administratorRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private TransitRepository transitRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ConnectRepository connectRepository;
    @Autowired
    private TakeRepository takeRepository;
    @Autowired
    private VisitSiteRepository visitSiteRepository;
    @Autowired
    private VisitEventRepository visitEventRepository;
    @Autowired
    private AssignToRepository assignToRepository;

    //Get ALL Assign_to
    @GetMapping(path = "/assign_tos")
    public @ResponseBody
    Collection<AssignTo> getAssignTos(){
        return assignToRepository.getAllAssignTos();
    }

    //Get ALL visit_events
    @GetMapping(path = "/visit_events")
    public @ResponseBody
    Collection<Visit_Event> getVisitEvents(){
        return visitEventRepository.getAllVisitEvents();
    }
    //Get ALL visit_sites
    @GetMapping(path = "/visit_sites")
    public @ResponseBody
    Collection<Visit_Site> getVisitSites(){
        return visitSiteRepository.getAllVisitSites();
    }

    //Get ALL takes
    @GetMapping(path = "/takes")
    public @ResponseBody
    Collection<Take> getTakes(){
        return takeRepository.getAllTakes();
    }
    //Get ALL connects
    @GetMapping(path = "/connects")
    public @ResponseBody
    Collection<Connect> getConnects(){
        return connectRepository.getAllConnects();
    }
    //Get ALL events
    @GetMapping(path = "/events")
    public @ResponseBody
    Collection<Event> getEvents(){
        return eventRepository.getAllEvents();
    }

    //Get ALL transit
    @GetMapping(path = "/transits")
    public @ResponseBody
    Collection<Transit> getTransits(){
        return transitRepository.getAllTransits();
    }

    //Get ALL Site
    @GetMapping(path = "/sites")
    public @ResponseBody
    Collection<Site> getSites(){
        return siteRepository.getAllSites();
    }

    //Get ALL users
    @GetMapping(path = "/users")
    public @ResponseBody
    Collection<User> getUsers(){
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return userRepository.getAllUsers();
    }

    //Get a single user
    @GetMapping(path = "/user") // Map ONLY GET Requests
    public @ResponseBody
    User getOneUser(@Param(value="username") String username){
        return userRepository.getOneUser(username);
    }

    //Check login credentials
    @GetMapping(path="/login")
    public @ResponseBody
    boolean checkLogin(@RequestHeader(value="username") String username, @RequestHeader(value="password") String password) {
        if(userRepository.checkLogin(username, password) != null) {
            return true;
        }

        return false;
    }


    @Transactional
    @PostMapping(path="/user")
    public @ResponseBody
    int createNewUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("username") String username, @RequestParam("password") String password){
        return userRepository.createNewUser(firstName, lastName, username, password);
    }


    //returns All Emails
    @GetMapping(path="/emails")
    public @ResponseBody
    Collection<Email> getAllEmail(){
        return emailRepository.getAllEmails();

    }

    //gets all the Emails associated w/ a user
    @GetMapping(path="/userEmails")
    public @ResponseBody
    Collection<Email> getAllUserEmails(@RequestParam("username")String username){
        return emailRepository.getAllUserEmails(username);

    }

    //gets all employee usernames
    @GetMapping(path="/employees")
    public @ResponseBody
    Collection<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

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

        return employeeRepository
                .createNewEmployee(username, employeeId, phone, address, city, state, zipcode);
    }

    //get all administrators
    @GetMapping(path="/administrators")
    public @ResponseBody
    Collection<Administrator> getAllAdministrators(){
        return administratorRepository.getAllAdministrators();
    }

    //get all managers
    @GetMapping(path="/managers")
    public @ResponseBody
    Collection<Manager> getAllManagers(){
        return managerRepository.getAllManagers();
    }

    //get all staff
    @GetMapping(path="/staff")
    public @ResponseBody
    Collection<Staff> getAllStaff(){
        return staffRepository.getAllStaff();
    }


//
//    @GetMapping(path="/visitors")
//    public @ResponseBody
//    Collection<Visitor> getAllVisitors(){
//        return visitorRepository.getAllVisitors();
//    }





}
