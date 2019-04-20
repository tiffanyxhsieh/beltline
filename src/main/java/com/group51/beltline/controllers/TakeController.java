package com.group51.beltline.controllers;

import com.group51.beltline.models.*;
import com.group51.beltline.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping
public class TakeController {

    @Autowired
    private TakeRepository takeRepository;

    //Get ALL takes
    @GetMapping(path = "/takes")
    public @ResponseBody
    Collection<Take> getTakes(){
        return takeRepository.getAllTakes();
    }

    //create a site
    @Transactional
    @PostMapping(path="/take")
    public @ResponseBody
    int createNewTake(@Param("username") String username, @Param("type") String type, @Param("route") String route, @Param("date") String date){
        // variables must be in lowwer case
        return takeRepository.createNewTake(username, type, route, date);
    }
    
}