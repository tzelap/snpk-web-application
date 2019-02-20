package com.snpk.webapplication.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.snpk.webapplication.media.model.Media;
import com.snpk.webapplication.user.User;


@Embeddable
public class RatingId implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_id", referencedColumnName = "id")
    private Media media;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
    public RatingId() {}
    
    public RatingId(User user, Media media) {
        this.user = user;
        this.media = media;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Media getMedia() {
        return media;
    }
    
    public void setMedia(Media media) {
        this.media = media;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((media == null) ? 0 : media.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        RatingId other = (RatingId) obj;
        if (media == null) {
            if (other.media != null)
                return false;
        } else if (!media.equals(other.media))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }
}
