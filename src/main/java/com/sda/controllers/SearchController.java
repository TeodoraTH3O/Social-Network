package com.sda.controllers;

import com.sda.entities.User;
import com.sda.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class SearchController {

    @Autowired
    private UserRepository userRepository;

//    @PostMapping("/search")
//    public String searchUsers(String name) throws UsernameNotFoundException {
//        Optional<User> searchByName = userRepository.findByName(name);
//        if(!searchByName.isPresent()){
//            throw new UsernameNotFoundException("User not found");
//        }
//        User searchUser = searchByName.get();
//        return "search_page";
//    }

//    @GetMapping("/search")
//    public String searchUsers(Model model,
//                             @ModelAttribute("searchController") SearchController userRepository,
//                             BindingResult result){
//        List<User> searchUser = this.userRepository.getClass(searchUsers(getName());
//        model.addAttribute("users", searchUser);
//        return "search_page";
//    }
}

