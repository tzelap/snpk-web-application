package com.snpk.webapplication.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.snpk.webapplication.media.MediaFactory;
import com.snpk.webapplication.media.MediaType;
import com.snpk.webapplication.media.MediaValidator;
import com.snpk.webapplication.media.model.Media;
import com.snpk.webapplication.media.model.Movie;
import com.snpk.webapplication.media.services.MediaService;


@Controller
public class AdminController {
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    MediaService mediaService;
    
    @Autowired
    MediaFactory mediaFactory;
    
    @Autowired
    MediaValidator mediaValidator;
    
    @Value("${omdb.api.key}")
    String apiKey;
    
    public static final String baseUrl = "http://www.omdbapi.com/";
    
    @RequestMapping(value = "/admin/collection", method = RequestMethod.GET)
    public String mediaCollection(
            @RequestParam(name = "type", required = false) MediaType mediaType, 
            @RequestParam(name = "title", required = false) String title, Model model) {
        boolean inDb = false;
        if(title != null) {
            Movie movie = restTemplate.getForObject(baseUrl + "?apikey=" + apiKey + "&plot=full"+ "&t=" + title, Movie.class);
            model.addAttribute("movie", movie);
            inDb = mediaService.findMovieByImdbID(movie.getImdbID()) == null ? false : true;
        }
        model.addAttribute("inDb", inDb);
        return "admin/collection";
    }
    
    @PostMapping("/admin/collection")
    public String searchMedia(@ModelAttribute(value = "movie") Movie movie, Model model) {
        mediaService.save((Media) movie);
        return "admin/collection";
    }
    
    /*
    @PostMapping("/admin/home")
    public String createMedia(@ModelAttribute("maRequest") @Valid MediaAddRequest maRequest, BindingResult bindingResult, Model model) {
        mediaValidator.validate(maRequest, bindingResult);
        if(!bindingResult.hasErrors()) {
            Media media = mediaFactory.buildMedia(maRequest.getMediaType(), maRequest.getName());
            model.addAttribute("successMessage", "Media succuesfully added to database");
            model.addAttribute("maRequest", new MediaAddRequest());
            mediaService.save(media);
        }
        
        return "admin/home";
    }
    */

}
