package com.snpk.webapplication.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.snpk.webapplication.media.services.MediaService;

@Component
public class MediaFactory implements Factory<Media, MediaType> {
    
    
    public Media buildMedia(MediaType type, String name) {
        Media media = null;
        System.out.println("media factory " +type.toString());
        
        try {
            media = getObject(type);
            media.setName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return media;
    }
    
    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public Media getObject(MediaType type) throws Exception {
        
        switch (type) {
        case MOVIE:
            return new Movie();
        case GAME:
            break;
        case MUSIC:
            break;
        default:
            break;
        }
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return null;
    }

    

   
}
