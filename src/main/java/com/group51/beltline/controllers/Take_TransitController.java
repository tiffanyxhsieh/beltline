package com.group51.beltline.controllers;

import com.group51.beltline.models.DTO.take_transit;
import com.group51.beltline.repository.Take_TransitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping
public class Take_TransitController {
    @Autowired
    Take_TransitRepository take_transitRepository;



    //TODO:FRONT END...must make default values
    @GetMapping(path="/screen16/filter")
    public @ResponseBody
    Collection<take_transit> getAlltake_transit(
                                                @RequestHeader(value="type") String type,
                                                @RequestHeader(value="route") String route,
                                                @RequestHeader(value="start") String start,
                                                @RequestHeader(value="end") String end){

        if(start == null || start.isEmpty()) {
            start = "1000-01-01";
        }

        if (end == null || end.isEmpty()) {
            end = "3000-01-01";
        }
        return take_transitRepository.gettake_transitBy(type,route, start, end);
    }
}
