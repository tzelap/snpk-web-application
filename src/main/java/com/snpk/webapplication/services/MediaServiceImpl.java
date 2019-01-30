package com.snpk.webapplication.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.snpk.webapplication.model.Media;
import com.snpk.webapplication.repository.MediaRepository;

public class MediaServiceImpl implements MediaService{
    @Autowired
    MediaRepository mediaRepository;

    @Override
    public void save(Media media) {
        media.setConsumed(false);
        mediaRepository.save(media);
    }

    @Override
    public Media findByName(String name) {
        return mediaRepository.findByName(name);
    }
    
}
