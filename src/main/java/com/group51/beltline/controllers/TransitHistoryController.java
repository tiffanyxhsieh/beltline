package com.group51.beltline.controllers;


import com.group51.beltline.models.Administrator;
import com.group51.beltline.repository.AdministratorRepository;
import com.group51.beltline.repository.TransitHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping
public class TransitHistoryController {

    @Autowired
    private TransitHistoryRepository transitHistoryRepository;

    @GetMapping(path="/transitHistory/filter")
    public @ResponseBody
    Collection<com.group51.beltline.models.DTO.TransitHistory> getUserTransitHistory(@Param("username") String username,
                                                                                     @Param("type") String type,
                                                                                     @Param("route") String route,
                                                                                     @Param("start") String start,
                                                                                     @Param("end") String end,
                                                                                     @Param("site") String site) {
        return transitHistoryRepository.getUserTransitHistory(username, type, route, start, end, site);
    }


}
