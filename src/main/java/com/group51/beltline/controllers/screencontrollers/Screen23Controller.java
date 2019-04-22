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

        //get a signle transit
        //Get transit by key tested
        @GetMapping(path = "/screen23/getOneTransit") // Map ONLY GET Requests
        public @ResponseBody
        Transit getTransitByName(@Param("Type") String type, @Param("Route") String route){
            return transitRepository.getTransitByKey(type, route);
        }

        // get a list of sites for a transit
        //Get sites for a transit tested
        @GetMapping(path = "/screen23/getConnectsByTransit")
        public @ResponseBody
        Collection<Connect> getConnectsByTransit(@Param("Type") String type,@Param("Route") String route){
            return connectRepository.getConnectsByTransit(type, route);
        }

        //update a transit
        // tested
        @Transactional
        @PutMapping(path="/screen23/updateTransit")
        public @ResponseBody
        int putNewTransitandConnect(@Param("Type") String type, @Param("Route") String route, @Param("Price") Double price, @Param("SiteName") String sitename){
            return transitRepository.updateNewTransit(type, route, price);
        }

        //delete Connects
        // tested
        @Transactional
        @DeleteMapping(path="/screen23/deleteConnects")
        public @ResponseBody
        int deleteConnects(@Param("SiteName") String sitename){
            return connectRepository.deleteConnects(sitename);
        }

        //update a Connect
        // tested
        @Transactional
        @PutMapping(path="/screen23/updateConnect")
        public @ResponseBody
        int putNewTransitandConnect(@Param("Type") String type, @Param("Route") String route, @Param("SiteName") String sitename){
            return connectRepository.createNewConnect(sitename, type, route);
        }

        //create a Connect
        //tested
        @Transactional
        @PostMapping(path="/screen23/createConnect")
        public @ResponseBody
        int createNewTake(@Param("SiteName") String sitename, @Param("Type") String type, @Param("Route") String route){
            // parameters' characters are in lowwer case
            return connectRepository.createNewConnect(sitename, type, route);
        }
    }
}