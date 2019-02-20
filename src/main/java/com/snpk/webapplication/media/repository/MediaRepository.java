package com.snpk.webapplication.media.repository;

import javax.transaction.Transactional;

import com.snpk.webapplication.media.model.Media;

@Transactional
public interface MediaRepository extends MediaBaseRepository<Media> {

}
