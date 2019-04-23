package com.group51.beltline.controllers;

import com.group51.beltline.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class VisitorController {
    @Autowired
    VisitorRepository visitorRepository;

    @GetMapping(path="/visitor")
    public @ResponseBody
    boolean isVisitor(@Param("username") String username) {

        if (visitorRepository.isVisitor(username) == 0) {
            return false;
        }
        return true;
    }
}
