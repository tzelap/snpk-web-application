package com.snpk.webapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.snpk.webapplication.repository.MovieRepository;
import com.snpk.webapplication.services.UserService;



@Controller
public class MainController {
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String home(Model model) {
        List<Object[]> results = movieRepository.findAllMoviesGroupedByNameDescScore();
        model.addAttribute("movieRatings", results);
        return "index";
    }
    
    @GetMapping("/admin/home")
    public String adminHome(Model model){
        return "admin/home";
    }
    
    @GetMapping("/profile/{profileUserName}")
    public String userInfo(@PathVariable("profileUserName") String profileUserName, Model model) {
        if(userService.findByUsername(profileUserName) == null) {
            return "error";
        }
        model.addAttribute("profileUserName", profileUserName);
        return "profile/userInfo";
    }
}
