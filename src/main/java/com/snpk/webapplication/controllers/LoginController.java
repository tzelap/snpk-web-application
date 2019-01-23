package com.snpk.webapplication.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.snpk.webapplication.model.User;
import com.snpk.webapplication.services.UserService;
import com.snpk.webapplication.validator.UserValidator;


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
    public String register(HttpServletRequest request, Model model) {
        User user = new User();;
        model.addAttribute("user", user);
        return "register";
    }
    
    @PostMapping("/register")
    public String register(@Valid@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        userValidator.validate(user, bindingResult);
        if(bindingResult.hasErrors()) {
            return "register";
        } else {
            userService.save(user);
            model.addAttribute("successMessage", "User successfully registered");
            model.addAttribute("user", new User());
        }
        return "register";
    }
    /*
     * 
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout";
    }
    */
}
