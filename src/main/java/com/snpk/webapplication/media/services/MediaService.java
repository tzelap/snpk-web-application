package com.snpk.webapplication.media.services;

import com.snpk.webapplication.media.model.Media;
import com.snpk.webapplication.media.model.Movie;

public interface MediaService {
    void save(Media media);
    Media findByTitle(String title);
    Movie findMovieByImdbID(String imdbID);
}
