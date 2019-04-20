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
public class ConnectController {

    @Autowired
    private ConnectRepository connectRepository;

    //Get ALL connects
    @GetMapping(path = "/connects")
    public @ResponseBody
    Collection<Connect> getConnects(){
        return connectRepository.getAllConnects();
    }

    //create a connect
    @Transactional
    @PostMapping(path="/connect")
    public @ResponseBody
    int createNewTake(@Param("SiteName") String sitename, @Param("Type") String type, @Param("Route") String route){
        // parameters' characters are in lowwer case
        return connectRepository.createNewConnect(sitename, type, route);
    }
    
}