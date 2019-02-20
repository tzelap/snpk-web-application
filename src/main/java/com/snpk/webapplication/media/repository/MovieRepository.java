package com.snpk.webapplication.media.repository;

import javax.transaction.Transactional;

import com.snpk.webapplication.media.model.Movie;

@Transactional
public interface MovieRepository extends MediaBaseRepository<Movie> {

}
