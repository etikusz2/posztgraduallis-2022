package edu.bbte.bibliospringjpa.controller;

import edu.bbte.bibliospringjpa.model.User;
import edu.bbte.bibliospringjpa.service.LoginService;
import edu.bbte.bibliospringjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @GetMapping
    @ResponseBody
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(path = "/testregistration")
    @ResponseBody
    public User testRegistration() {
        User user = new User();
        user.setUsername("Etelka");
        user.setPassword("Etelka");

        return loginService.register(user);
    }

    @GetMapping(path = "/testlogin")
    @ResponseBody
    public boolean testLogin() {
        User user = new User();
        user.setUsername("Etelka");
        user.setPassword("Etelka");

        return loginService.login(user);
    }

    @GetMapping(path = "/testdelete")
    @ResponseBody
    public boolean testDelete() {
        User user = new User();
        user.setUsername("Etelka");
        user.setPassword("Etelka");
        user.setId(25L);

        return userService.delete(user);
    }

    @GetMapping(path = "/testgetbyid")
    @ResponseBody
    public User testGetById() {
        return userService.getById(20L);
    }


}
