package com.snpk.webapplication.services;

import java.net.URL;

import com.amazonaws.services.s3.model.S3Object;


public interface S3Service {
    S3Object findS3Object(String path);
    URL getGeneratedPresignedUrl(String fileName);
}