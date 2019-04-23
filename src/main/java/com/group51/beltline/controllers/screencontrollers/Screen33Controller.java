
package com.group51.beltline.controllers.screencontrollers;

import com.group51.beltline.models.*;
import com.group51.beltline.models.views.*;
import com.group51.beltline.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

// need to test
@Controller
@RequestMapping
public class Screen33Controller {

    @Autowired
    private Screen33viewRepository screen33viewRepository;

    // filter for screen 33, tested
    // visited = 1 for checked (show the events that the visitor visied), visited = 0 for uncheck
    // soldout = 1 for checked (show all events), soldout = 0 for uncheck (only show the events which have ticket rem)
    @GetMapping(path = "/screen33/filter")
    public @ResponseBody
    Collection<Screen33view> filter(@Param("username") String username, @Param("name") String name, @Param("keyword") String keyword, @Param("sitename") String sitename, @Param("startdate") String startdate, @Param("enddate") String enddate, @Param("visited") Integer visited, @Param("soldout") Integer soldout){
        return screen33viewRepository.filter(username, name, keyword, sitename, startdate, enddate, visited, soldout);
    }
    // @GetMapping(path = "/screen33/filter")
    // public @ResponseBody
    // Collection<Screen33view> filter(@Param("username") String username){
    //     return screen33viewRepository.filter(username);
    // }

}