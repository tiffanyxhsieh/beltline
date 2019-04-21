package com.group51.beltline.controllers;

import com.group51.beltline.models.DTO.take_transit;
import com.group51.beltline.repository.Take_TransitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping
public class Take_TransitController {
    @Autowired
    Take_TransitRepository take_transitRepository;

    @GetMapping(path="/screen16/filter")
    public @ResponseBody
    Collection<take_transit> getAlltake_transit(){
        return take_transitRepository.getAlltake_transit();
    }
}
