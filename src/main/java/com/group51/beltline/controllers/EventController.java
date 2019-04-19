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
public class EventController {
    @Autowired
    private EventRepository eventRepository;

    //Get ALL events
    @GetMapping(path = "/events")
    public @ResponseBody
    Collection<Event> getEvents(){
        return eventRepository.getAllEvents();
    }
}