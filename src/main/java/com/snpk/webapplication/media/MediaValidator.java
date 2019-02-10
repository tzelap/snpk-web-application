package com.snpk.webapplication.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.snpk.webapplication.media.services.MediaService;

@Component
public class MediaValidator implements Validator {
    @Autowired
    MediaService mediaService;
 
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Media.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Media media = (Media) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if(mediaService.findByName(media.getName()) != null) {
            errors.rejectValue("name", "Duplicate.media.name");
        }
    }
    
   
}
