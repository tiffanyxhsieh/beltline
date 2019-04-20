package com.group51.beltline.controllers;

import com.group51.beltline.models.Email;
import com.group51.beltline.repository.AssignToRepository;
import com.group51.beltline.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //gets all the Emails associated w/ a user
    @GetMapping(path="/userEmails")
    public @ResponseBody
    Collection<Email> getAllUserEmails(@RequestParam("username")String username){
        return emailRepository.getAllUserEmails(username);

    }
}
