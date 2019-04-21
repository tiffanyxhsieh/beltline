package com.group51.beltline.controllers.screencontrollers;

import com.group51.beltline.models.*;
import com.group51.beltline.models.DTO.Manage_transit;
import com.group51.beltline.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

// TODO: filter the view for info
@Controller
@RequestMapping
public class Screen22Controller {
    @Autowired
    private TransitRepository transitRepository;

    @Autowired
    private Manage_transitRepository manage_transitRepository;

    //Get ALL manage_transit
    @GetMapping(path = "/screen22/showTable")
    public @ResponseBody
    Collection<Manage_transit> getSites(){
        return manage_transitRepository.getAllManageTransit();
    }

    //create a transit
    @Transactional
    @PostMapping(path="/screen22/create")
    public @ResponseBody
    int createNewTransit(@Param("Type") String type, @Param("Route") String route, @Param("Price") Double price){
        return transitRepository.createNewTransit(type, route, price);
    }
}