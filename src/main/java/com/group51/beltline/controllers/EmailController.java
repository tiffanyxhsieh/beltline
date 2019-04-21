package com.group51.beltline.controllers;

import com.group51.beltline.models.Email;
import com.group51.beltline.repository.AssignToRepository;
import com.group51.beltline.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;

@Controller
@RequestMapping
public class EmailController {

    @Autowired
    private EmailRepository emailRepository;



    //returns All Emails
    @GetMapping(path="/emails")
    public @ResponseBody
    Collection<Email> getAllEmail(){
        return emailRepository.getAllEmails();

    }

    @Transactional
    @PostMapping(path="/emails")
    public @ResponseBody
    int addEmailToUser(@RequestHeader("username") String username, @RequestHeader("email") String email) {
        return emailRepository.addEmail(username, email);
    }


    //gets all the Emails associated w/ a user
    @GetMapping(path="/userEmails")
    public @ResponseBody
    Collection<Email> getAllUserEmails(@RequestHeader("username")String username){
        return emailRepository.getAllUserEmails(username);
    }

    @GetMapping(path="/emailExists")
    public @ResponseBody
    int emailExists(@RequestHeader("email") String email) {
        return emailRepository.emailExists(email);
    }
}
