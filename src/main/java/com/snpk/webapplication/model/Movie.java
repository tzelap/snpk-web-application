package com.snpk.webapplication.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Entity
@DiscriminatorValue(value = "Movie")
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
   
    @Enumerated(EnumType.STRING)
    private MpaRating mpaRating;
    
    
    public MpaRating getMpaRating() {
        return this.mpaRating;
    }
    
    public void setMpaRating(MpaRating mpaRating) {
        this.mpaRating = mpaRating;
    }
    
    
}
