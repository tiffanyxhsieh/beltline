package com.group51.beltline.controllers;

import com.group51.beltline.models.DTO.take_transit;
import com.group51.beltline.models.DTO.take_transit1;
import com.group51.beltline.models.User;
import com.group51.beltline.repository.Take_TransitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    @GetMapping(path="/screen15/filter")
    public @ResponseBody
    Collection<take_transit> getAlltake_transit(
                                                @Param(value="site") String site,
                                                @Param(value="type") String type,
                                                @Param(value="low") String low,
                                                @Param(value="high") String high){
        //TODO: FRONT END.....if low is empty, put "0", if high is empty, put "99999
        return take_transitRepository.filterTake_transitBy(site, type, low, high);
    }



}
