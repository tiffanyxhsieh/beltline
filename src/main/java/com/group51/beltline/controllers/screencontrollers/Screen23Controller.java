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

@Controller
@RequestMapping
public class Screen23Controller {
    @Controller
    @RequestMapping
    public class TransitController {
        @Autowired
        private TransitRepository transitRepository;
        @Autowired
        private ConnectRepository connectRepository;

        //update a transit
        @Transactional
        @PutMapping(path="/screen23/updateTransit")
        public @ResponseBody
        int putNewTransitandConnect(@Param("Type") String type, @Param("Route") String route, @Param("Price") Double price, @Param("SiteName") String sitename){
            return transitRepository.updateNewTransit(type, route, price);
        }

        //delete Connects
        // need to test
        @Transactional
        @DeleteMapping(path="/screen23/deleteConnects")
        public @ResponseBody
        int deleteConnects(@Param("SiteName") String sitename){
            return connectRepository.deleteConnects(sitename);
        }

        //update a Connect
        @Transactional
        @PutMapping(path="/screen23/updateConnect")
        public @ResponseBody
        int putNewTransitandConnect(@Param("Type") String type, @Param("Route") String route, @Param("SiteName") String sitename){
            return connectRepository.createNewConnect(sitename, type, route);
        }
    }
}