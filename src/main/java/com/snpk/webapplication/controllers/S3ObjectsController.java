package com.snpk.webapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.snpk.webapplication.services.S3Service;


@RestController
public class S3ObjectsController {
    
    @Autowired
    private S3Service s3Service;
    
    @GetMapping("/admin/s3/{subFolder}/{fileName}")
    public ResponseEntity<InputStreamResource> downloadAdminImages (@PathVariable("subFolder") String subFolder, @PathVariable("fileName") String fileName){
        String path = subFolder + "/" + fileName;
        S3Object s3Obj = s3Service.findS3Object(path);
        S3ObjectInputStream s3In = s3Obj.getObjectContent();
        ObjectMetadata objMetadata = s3Obj.getObjectMetadata();
        return ResponseEntity.ok()
                .contentLength(objMetadata.getContentLength())
                .contentType(MediaType.parseMediaType(s3Obj.getObjectMetadata().getContentType()))
                .body(new InputStreamResource(s3In));
                        
    }  
}
