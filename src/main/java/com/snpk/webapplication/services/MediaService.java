package com.snpk.webapplication.services;

import com.snpk.webapplication.model.Media;

public interface MediaService {
    void save(Media media);
    Media findByName(String name);
}
