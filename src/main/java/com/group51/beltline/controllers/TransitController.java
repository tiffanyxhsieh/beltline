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
public class TransitController {
    @Autowired
    private TransitRepository transitRepository;

    //Get ALL transit
    @GetMapping(path = "/transits")
    public @ResponseBody
    Collection<Transit> getTransits(){
        return transitRepository.getAllTransits();
    }

    //Get transit by key
    @GetMapping(path = "/transit") // Map ONLY GET Requests
    public @ResponseBody
    Transit getTransitByName(@Param("Type") String type, @Param("Route") String route){
        return transitRepository.getTransitByKey(type, route);
    }

    //create a transit
    @Transactional
    @PostMapping(path="/transit")
    public @ResponseBody
    int createNewTransit(@Param("Type") String type, @Param("Route") String route, @Param("Price") Double price){
        return transitRepository.createNewTransit(type, route, price);
    }

    //update a transit
    @Transactional
    @PutMapping(path="/transit")
    public @ResponseBody
    int putNewTransit(@Param("Type") String type, @Param("Route") String route, @Param("Price") Double price){
        return transitRepository.updateNewTransit(type, route, price);
    }

    //delete a transit
    @Transactional
    @DeleteMapping(path="/transit")
    public @ResponseBody
    int deleteTransit(@Param("Type") String type, @Param("Route") String route){
        return transitRepository.deleteTransit(type, route);
    }
}