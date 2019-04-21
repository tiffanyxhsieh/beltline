package com.group51.beltline.controllers;

import com.group51.beltline.models.User;
import com.group51.beltline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    UserRepository userRepository;

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
    int createNewUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("username") String username, @RequestParam("password") String password){
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

}
