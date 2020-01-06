package com.sda.controllers;

import com.sda.entities.User;
import com.sda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String showUpdateForm(Model model) {
        List<User> users = (List<User>) userService.findAll();
        model.addAttribute("users", users);

        User u = new User();
        u.setEmail("a@a");
        u.setName("123");
        userService.save(u);

        return "home_page";
    }

}
