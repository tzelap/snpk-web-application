package com.snpk.webapplication.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.snpk.webapplication.user.User;
import com.snpk.webapplication.user.UserService;
import com.snpk.webapplication.user.UserValidator;


@Controller
public class LoginController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserValidator userValidator;
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/register")
    public String register(User user) {
        return "register";
    }
    
    @PostMapping("/register")
    public String register(@Valid User user, BindingResult bindingResult, Model model) {
        userValidator.validate(user, bindingResult);
        if(!bindingResult.hasErrors()) {
            userService.save(user);
            model.addAttribute("successMessage", "User successfully registered");
            model.addAttribute("user", new User());
        }
        return "register";
    }
}
