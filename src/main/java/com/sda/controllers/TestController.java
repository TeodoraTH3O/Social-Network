package com.sda.controllers;

import com.sda.entities.User;
import com.sda.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class TestController {

    private UserRepository userRepository;

    @Autowired
    public TestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/search2")
    public String searchUsers(Model model, User user) throws UsernameNotFoundException {
        if (user == null){
            user = new User();
        }
        model.addAttribute("user", user);
        return "search";
    }

    @PostMapping("/search2")
    public String searchUsers(User user, Model model) throws UsernameNotFoundException {
        Optional<User> searchByName = userRepository.findByName(user.getName());
        User searchUser = searchByName.get();
        model.addAttribute("user", searchUser);
        return "search";
    }


}
