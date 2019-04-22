
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
public class Screen31Controller {

    @Autowired
    private Screen31viewRepository screen31viewRepository;

    // filter
    @GetMapping(path = "/screen31/filter")
    public @ResponseBody
    Collection<Screen31view> initByManager(@Param("username") String username, @Param("name") String name, @Param("description") String description, @Param("start_date") String start_date, @Param("end_date") String end_date){
        return screen31viewRepository.filter(username, name, description, start_date, end_date);
    }
}