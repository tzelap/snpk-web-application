package com.snpk.webapplication.media;

public enum MediaType {
    MOVIE("Movie"),
    GAME("Game"),
    MUSIC("Music");
    
    private final String displayName;
    
    MediaType(String displayName){
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
