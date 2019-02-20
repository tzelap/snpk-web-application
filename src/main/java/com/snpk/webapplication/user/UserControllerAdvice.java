package com.snpk.webapplication.user;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;



@ControllerAdvice
public class UserControllerAdvice {
    
    @ModelAttribute
    public void userAttributeRequest(HttpServletRequest request, Model model) {
        Principal principal = request.getUserPrincipal();
        Boolean isAdmin = request.isUserInRole("ADMIN");
        if(principal != null) {
            String userName = principal.getName();
            model.addAttribute("loggedInUserName", userName);
            model.addAttribute("isAdmin", isAdmin);
        }
    }
}
