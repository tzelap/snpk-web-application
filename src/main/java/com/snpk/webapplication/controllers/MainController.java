package com.snpk.webapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.snpk.webapplication.media.MediaRepository;
import com.snpk.webapplication.user.UserService;



@Controller
public class MainController {
    @Autowired
    private MediaRepository mediaRepository;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String home(Model model) {
        List<Object[]> results = mediaRepository.findAllMediaGroupedByNameDescScore();
        model.addAttribute("movieRatings", results);
        return "index";
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
