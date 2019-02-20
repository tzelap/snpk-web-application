package com.snpk.webapplication.media.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.snpk.webapplication.media.model.Media;

@NoRepositoryBean
public interface MediaBaseRepository<T extends Media> extends JpaRepository<T, UUID>{
    @Query("SELECT m.title, AVG(r.score)" 
            + " FROM Media m"
            + " JOIN m.ratings r"
            + " GROUP BY m.title"
            + " ORDER BY r.score DESC")
    List<Object[]> findAllMediaGroupedByNameDescScore();
    Media findByTitle(String title);
}
