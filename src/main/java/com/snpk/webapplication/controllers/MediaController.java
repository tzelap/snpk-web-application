package com.snpk.webapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MediaController {
    
    @GetMapping("/movie")
    public String showMoviePage(Model model) {
        return null;
        
    }
    
    @GetMapping("/music")
    public String showMusicPage(Model model) {
        return null;
        
    }
}
