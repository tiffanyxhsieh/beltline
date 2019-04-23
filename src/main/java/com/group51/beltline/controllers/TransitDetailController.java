package com.group51.beltline.controllers;

import com.group51.beltline.repository.TransitDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

@Controller
@RequestMapping

public class TransitDetailController {
    @Autowired
    TransitDetailRepository transitDetailRepository;

    @Transactional
    @PostMapping("/screen36/load")
    void loadTransitDetails(@Param("sitename") String sitename){
        transitDetailRepository.dropOldtransit_detailView();
        transitDetailRepository.loadTransitDetail(sitename);
    }

}
