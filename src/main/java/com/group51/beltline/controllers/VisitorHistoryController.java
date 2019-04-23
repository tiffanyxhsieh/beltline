package com.group51.beltline.controllers;

import com.group51.beltline.models.DTO.VisitorHistory;
import com.group51.beltline.repository.VisitorHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping
public class VisitorHistoryController {
    @Autowired
    VisitorHistoryRepository visitorHistoryRepository;

    @GetMapping("/screen37/filter")
    public @ResponseBody
    Collection<VisitorHistory> getVisitorHistory(@Param("username") String username,
                                                 @Param("event") String event,
                                                 @Param("site") String site,
                                                 @Param("start") String start,
                                                 @Param("end") String end
    ) {
        return visitorHistoryRepository.getVisitorHistory(username, event, site, start, end);
    }
}
