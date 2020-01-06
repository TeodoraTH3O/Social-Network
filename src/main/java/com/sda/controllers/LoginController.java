package com.sda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String redirectLogin(){
        return "home_page";
    }

    @GetMapping("/user_profile_page")
    public String redirectToUserProfile(){
        return "user_profile_page";
    }

    @GetMapping("/logout")
    public String redirectLogout(){
        return "home_page";
    }
}
