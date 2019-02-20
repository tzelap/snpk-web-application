package com.snpk.webapplication.media.model;

import javax.validation.constraints.NotNull;

import com.snpk.webapplication.media.MediaType;

public class MediaAddRequest {
    
    private String name;
    @NotNull(message = "Media type is required")
    private MediaType mediaType;
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public MediaType getMediaType() {
        return mediaType;
    }
    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}
