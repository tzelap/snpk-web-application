package com.snpk.webapplication.media.services;

import com.snpk.webapplication.media.Media;
import com.snpk.webapplication.media.Movie;

public interface MediaService {
    void save(Media media);
    Media findByName(String name);

}
