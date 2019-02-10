package com.snpk.webapplication.media;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("movieRepository")
public interface MediaRepository extends JpaRepository<Media, Long>{
    @Query("SELECT m.name, AVG(r.score)" 
            + " FROM Media m"
            + " JOIN m.ratings r"
            + " GROUP BY m.name"
            + " ORDER BY r.score DESC")
    public List<Object[]> findAllMediaGroupedByNameDescScore();
    Media findByName(String name);
}