package com.group51.beltline.controllers.screencontrollers;

import com.group51.beltline.models.*;
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
public class Screen24Controller {
    @Controller
    @RequestMapping
    public class TransitController {
        @Autowired
        private TransitRepository transitRepository;
        @Autowired
        private ConnectRepository connectRepository;

        //update a transit
        @Transactional
        @PostMapping(path="/screen24/createTransit")
        public @ResponseBody
        int putNewTransitandConnect(@Param("Type") String type, @Param("Route") String route, @Param("Price") Double price, @Param("SiteName") String sitename){
            return transitRepository.createNewTransit(type, route, price);
        }

        //update a Connect
        @Transactional
        @PostMapping(path="/screen24/createConnect")
        public @ResponseBody
        int putNewTransitandConnect(@Param("Type") String type, @Param("Route") String route, @Param("SiteName") String sitename){
            return connectRepository.createNewConnect(sitename, type, route);
        }
    }
}