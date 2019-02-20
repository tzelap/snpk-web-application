package com.snpk.webapplication.media.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snpk.webapplication.media.model.Media;
import com.snpk.webapplication.media.model.Movie;
import com.snpk.webapplication.media.repository.MediaRepository;
import com.snpk.webapplication.media.repository.MovieRepository;

@Service
public class MediaServiceImpl implements MediaService {
    @Autowired
    MovieRepository movieRepository;
    
    @Autowired
    MediaRepository mediaRepository;
    
    @Override
    public void save(Media media) {
        if(media instanceof Movie) {
            Movie movie = (Movie) media;
            String imdbID = movie.getImdbID();
            UUID id = convertFromImdbID(imdbID);
            movie.setId(id == null ? UUID.randomUUID() : id);
            movieRepository.save(movie);
        }
        
    }
    
    @Override
    public Media findByTitle(String title) {
        return mediaRepository.findByTitle(title);
    }
    
    @Override
    public Movie findMovieByImdbID(String imdbID) {
        UUID fromImdbID = convertFromImdbID(imdbID);
        Optional<Movie> findByImdbID = movieRepository.findById(fromImdbID);
        return (findByImdbID.isPresent() ? findByImdbID.get() : null);
    }
    
    protected UUID convertFromImdbID(String imdbID) {
        if(isValidImdbIDformat(imdbID)) {
            try {
                return UUID.nameUUIDFromBytes(imdbID.getBytes());
            } catch(NullPointerException e) {
                e.printStackTrace();
            }
        }
        return null;   
    }
    
    protected Boolean isValidImdbIDformat(String imdbID) {
        return (imdbID.matches("\\w{2}(\\d{7})") ? true: false);
    }
    /*
    @Override
    public Media findById(Long id) {
        Media byId = null;
        Optional<Media> media = mediaRepository.findById(id);
        if(media.isPresent()) {
            byId = media.get();
        }
        return byId;
    }
    
     * (non-Javadoc)
     * @see com.snpk.webapplication.media.services.MediaService#findById(java.lang.String)
     * use imdbID format 2 chars and 7 numbers
     
    @Override
    public Media findById(String imdbID) {
        Media byImdbID = null;
        if(imdbID.matches("\\w{2}(\\d{7})")) {
            int id = Integer.valueOf(imdbID.substring(2));
            Optional<Media> media = mediaRepository.findById(Long.valueOf(id));
            if(media.isPresent()) {
                byImdbID = media.get();
            }
        }
        return byImdbID;
        
    }
    */

}
