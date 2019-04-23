package com.group51.beltline.controllers.screencontrollers;

import com.group51.beltline.models.*;
import com.group51.beltline.models.views.Manage_transit;
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
public class Screen22Controller {
    @Autowired
    private TransitRepository transitRepository;

    @Autowired
    private Manage_transitRepository manage_transitRepository;

    //Get ALL manage_transit
    // tested
    @GetMapping(path = "/screen22/showTable")
    public @ResponseBody
    Collection<Manage_transit> getAll(@Param("type") String type, @Param("route") String route, @Param("sitename") String sitename, @Param("price_low") String price_low, @Param("price_high") String price_high){
        return manage_transitRepository.getAllManageTransit(type, route, sitename, price_low, price_high);
    }

    //create a transit
    //tested
    @Transactional
    @PostMapping(path="/screen22/createtransit")
    public @ResponseBody
    int createNewTransit(@Param("Type") String type, @Param("Route") String route, @Param("Price") Double price){
        return transitRepository.createNewTransit(type, route, price);
    }

    // delete a transit
    //tested
    @Transactional
    @DeleteMapping(path="/screen22/deletetransit")
    public @ResponseBody
    int deleteTransit(@Param("Type") String type, @Param("Route") String route){
        return transitRepository.deleteTransit(type, route);
    }
}