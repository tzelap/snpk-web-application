package com.snpk.webapplication.model;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Rating {
    
    /*
     * This is the primarykey
     */
    @EmbeddedId
    private RatingId ratingId;

    

    private BigDecimal score;
    /*
     * 
     
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    private Movie movReviewed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User reviewer;
    */
    public Rating() {

    }

    public Rating(RatingId ratingId, BigDecimal score /* ,Movie movReviewed, User reviewer */) {
        this.ratingId = ratingId;
        this.score = score;
        // this.movReviewed = movReviewed;
        // this.reviewer = reviewer;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public RatingId getRatingId() {
        return ratingId;
    }

    public void setRateId(RatingId ratingId) {
        this.ratingId = ratingId;
    }
    
    @Override
    public String toString() {
        return String.format("Rating [user= %s, movie= %s, score= %s]", ratingId.getUser().getUsername(), ratingId.getMovie().getName(), score);
    }
}
