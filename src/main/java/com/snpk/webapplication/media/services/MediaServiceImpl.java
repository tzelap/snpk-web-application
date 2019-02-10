package com.snpk.webapplication.media.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snpk.webapplication.media.Media;
import com.snpk.webapplication.media.MediaRepository;
import com.snpk.webapplication.media.Movie;

@Service
public class MediaServiceImpl implements MediaService {
    @Autowired
    MediaRepository mediaRepository;
    
    @Override
    public void save(Media media) {
        mediaRepository.save(media);
    }

    @Override
    public Media findByName(String name) {
        return mediaRepository.findByName(name);
    }

}
