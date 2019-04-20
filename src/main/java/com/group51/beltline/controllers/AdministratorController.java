package com.group51.beltline.controllers;

import com.group51.beltline.models.Administrator;
import com.group51.beltline.repository.AdministratorRepository;
import com.group51.beltline.repository.AssignToRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping
public class AdministratorController {

    @Autowired
    private AdministratorRepository administratorRepository;


    //get all administrators
    @GetMapping(path="/administrators")
    public @ResponseBody
    Collection<Administrator> getAllAdministrators(){
        return administratorRepository.getAllAdministrators();
    }

}
