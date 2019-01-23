package com.snpk.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snpk.webapplication.model.Rating;
import com.snpk.webapplication.model.RatingId;

@Repository("ratingRepository")
public interface RatingRepository extends JpaRepository<Rating, RatingId> {

}
