package com.snpk.webapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.snpk.webapplication.model.Movie;

@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Long>{
    @Query("SELECT m.name, AVG(r.score)" 
            + " FROM Movie m"
            + " JOIN m.ratings r"
            + " GROUP BY m.name"
            + " ORDER BY r.score DESC")
    public List<Object[]> findAllMoviesGroupedByNameDescScore();
}
