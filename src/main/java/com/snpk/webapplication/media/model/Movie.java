package com.snpk.webapplication.media.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@DiscriminatorValue(value = "Movie")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie extends Media{
    /*
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    
    @OneToMany(mappedBy = "ratingId.movie")
    private Set<Rating> ratings;
    */
    
    public enum MpaRating {
        NC17, R, PG13, PG, G;
    };
    
    @JsonProperty("Rated")
    @Enumerated(EnumType.STRING)
    private MpaRating mpaRating;
    
    @Transient
    private String imdbID;
    
    @JsonProperty("Plot")
    @Transient
    private String plot;
    
    public MpaRating getMpaRating() {
        return this.mpaRating;
    }
    
    public void setMpaRating(MpaRating mpaRating) {
        this.mpaRating = mpaRating;
    }
    
    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }
        
}
