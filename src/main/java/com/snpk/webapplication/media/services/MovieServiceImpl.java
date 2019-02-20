package com.snpk.webapplication.media.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snpk.webapplication.media.MediaRepository;
import com.snpk.webapplication.media.model.Media;
import com.snpk.webapplication.media.model.Movie;

@Service
public class MovieServiceImpl extends MediaServiceImpl {
    @Autowired
    MediaRepository mediaRepository;

    @Override
    public void save(Media media) {
        if(media instanceof Movie) {
            Movie movie = (Movie) media;
            UUID id = convertFromString(movie.getImdbID());
            movie.setId(id == null ? UUID.randomUUID() : id);
            mediaRepository.save(movie);
        }  
    }

    @Override
    public Movie findByTitle(String title) {
        return (Movie)mediaRepository.findByTitle(title);
    }
    
    public Movie findByImdbID(String imdbID) {
        UUID fromImdbID = convertFromString(imdbID);
        Optional<Media> findByImdbID = mediaRepository.findById(fromImdbID);
        return (findByImdbID.isPresent() ? (Movie)findByImdbID.get() : null);
    }
    
    public UUID convertFromString(String imdbID) {
        try {
            return UUID.nameUUIDFromBytes(imdbID.getBytes());
        } catch(NullPointerException e) {
            e.printStackTrace();
        }
        return null;
        
    }


}
