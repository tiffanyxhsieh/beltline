package com.group51.beltline.controllers;

import com.group51.beltline.models.DTO.ManageUser;
import com.group51.beltline.models.User;
import com.group51.beltline.repository.ManageUserRepository;
import com.group51.beltline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ManageUserRepository manageUserRepository;

    //Get ALL users
    @GetMapping(path = "/users")
    public @ResponseBody
    Collection<User> getUsers(){
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return userRepository.getAll();
    }

    //Get a single user
    @GetMapping(path = "/user") // Map ONLY GET Requests
    public @ResponseBody
    User getOneUser(@RequestHeader(value="username") String username){
        return userRepository.getOneUser(username);
    }



    //create a new user
    //TODO: ERROR HANDLING FOR DUPLICATE KEYS
    @Transactional
    @PostMapping(path="/user")
    public @ResponseBody
    int createNewUser(@RequestHeader("firstName") String firstName, @RequestHeader("lastName") String lastName, @RequestHeader("username") String username, @RequestHeader("password") String password){
        return userRepository.createNewUser(firstName, lastName, username, password);
    }

    @Transactional
    @PutMapping(path="/screen18/approve")
    public @ResponseBody
    int approveUser(@RequestHeader("username") String username){
        return userRepository.approveUser(username);
    }

    @Transactional
    @PutMapping(path="/screen18/decline")
    public @ResponseBody
    int declineUser(@RequestHeader("username") String username){
        return userRepository.declineUser(username);
    }


    @GetMapping(path="/screen18/filter")
    public @ResponseBody
    Collection<ManageUser> filterManagedUsers(@Param("username") String username, @Param("status") String status, @Param("type") String type){
        return manageUserRepository.adminManageUserFilter(username, status, type);
    }


    @GetMapping(path="/usernameExists")
    public @ResponseBody
    int usernameExists(@RequestHeader("username") String username) {
        return userRepository.usernameExists(username);
    }

    @GetMapping(path="/phoneExists")
    public @ResponseBody
    int phoneExists(@RequestHeader("phone") String phone) {
        return userRepository.phoneExists(phone);
    }
}
