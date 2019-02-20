package com.snpk.webapplication.media;

import org.springframework.stereotype.Component;

import com.snpk.webapplication.media.model.Media;
import com.snpk.webapplication.media.model.Movie;
import com.snpk.webapplication.services.interfaces.Factory;



@Component
public class MediaFactory implements Factory<Media, MediaType> {
    
    
    public Media buildMedia(MediaType type, String title) {
        Media media = null;
        System.out.println("media factory " + type.toString());
        System.out.println("media factory " + title);
        try {
            media = getObject(type);
            media.setTitle(title);
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
