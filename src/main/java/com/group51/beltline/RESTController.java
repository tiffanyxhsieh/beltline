package com.group51.beltline;

import com.group51.beltline.models.User;
import com.group51.beltline.models.Site;
import com.group51.beltline.repository.UserRepository;
import com.group51.beltline.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping
public class RESTController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SiteRepository siteRepository;

    @GetMapping(path="/all")
	public @ResponseBody Iterable<Site> getAllSites() {
		// This returns a JSON or XML with the users
		return siteRepository.findAll();
	}

    //Get ALL Site
    @GetMapping(path = "/sites")
    public @ResponseBody
    Collection<Site> getSites(){
        return siteRepository.getAllSites();
    }

    //Get ALL users
    @GetMapping(path = "/users")
    public @ResponseBody
    Collection<User> getUsers(){
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        return userRepository.getAllUsers();
    }

    //Get a single user
    @GetMapping(path = "/user") // Map ONLY GET Requests
    public @ResponseBody
    User getOneUser(@Param(value="username") String username){
        return userRepository.getOneUser(username);
    }

    //Check login credentials
    @PostMapping(path="/login")
    public @ResponseBody
    boolean checkLogin(@Param(value="username") String username, @Param(value="password") String password) {
        if(userRepository.checkLogin(username, password) != null) {
            return true;
        }

        return false;
    }


    @Transactional
    @PostMapping(path="/user")
    public @ResponseBody
    int createNewUser(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("username") String username, @Param("password") String password){
        return userRepository.createNewUser(firstName, lastName, username, password);
    }









}
