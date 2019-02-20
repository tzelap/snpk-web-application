package com.snpk.webapplication.media.model;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.snpk.webapplication.model.MediaCredit;
import com.snpk.webapplication.model.Rating;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "MEDIA_TYPE")
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Media {
    
    @Id
    @Column(nullable = false, name = "id", columnDefinition = "BINARY(16)")
    /*
    @GeneratedValue(generator="IdOrGenerated")
    @GenericGenerator(name="UUIDgenerate", strategy = "com.snpk.webapplication.media.model.UUIDGenerator")
    */
    private UUID id;
    
    @NotNull
    @JsonProperty("Title")
    private String title;

    private Integer length;
    
    LocalDate releaseDate;
    
    @OneToMany(mappedBy = "ratingId.media")
    private Set<Rating> ratings;
    
    @OneToMany(mappedBy = "media")
    private Set<MediaCredit> credits;
    
    @JsonProperty("Poster")
    private String posterUrl;
    
    public Media() {}
    
    public String getTitle() {
        return title;
    }

    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }
    
    public void setLength(Integer length) {
        this.length = length;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }
    
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public Set<MediaCredit> getCredits() {
        return credits;
    }

    public void setCredits(Set<MediaCredit> credits) {
        this.credits = credits;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Media other = (Media) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }
    
}
