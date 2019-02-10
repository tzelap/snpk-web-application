package com.snpk.webapplication.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.snpk.webapplication.media.Media;
import com.snpk.webapplication.media.MediaFactory;
import com.snpk.webapplication.media.MediaType;
import com.snpk.webapplication.media.MediaValidator;
import com.snpk.webapplication.media.Movie;
import com.snpk.webapplication.media.services.MediaService;

@Controller
public class AdminController {
    @Autowired
    MediaService mediaService;
    
    @Autowired
    MediaFactory mediaFactory;
    
    @Autowired
    MediaValidator mediaValidator;
    
    @GetMapping("/admin/home")
    public String adminHome() {
        return "admin/home";
    }
    
    @PostMapping("/admin/home")
    public String createMedia(@RequestParam("mediaType") MediaType mediaType, @RequestParam("name") String name) {
        System.out.println(mediaType.toString());
        System.out.println(name);
        Media media = mediaFactory.buildMedia(mediaType, name);
        mediaService.save(media);
        return "admin/home";
    }
}
