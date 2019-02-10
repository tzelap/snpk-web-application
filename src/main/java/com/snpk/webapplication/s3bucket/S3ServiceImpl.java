package com.snpk.webapplication.s3bucket;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

@Service
public class S3ServiceImpl implements S3Service {
    
    @Autowired
    private AmazonS3 s3Client;
    
    @Value("${snpk.s3.bucket}")
    private String bucketName;
    
    @Value("${snpk.s3.key-prefix}")
    private String keyPrefix;
    
    @Override
    public S3Object findS3Object(String path) {
        System.out.println(keyPrefix+path);
        try {
            S3Object s3Obj = s3Client.getObject(new GetObjectRequest(bucketName, keyPrefix + path));
            return s3Obj;
        } catch (AmazonServiceException ase) {
            ase.printStackTrace();
            throw ase;
        } catch (AmazonClientException ace) {
            ace.printStackTrace();
            throw ace;
        }
    }
    
    @Override
    public URL getGeneratedPresignedUrl(String path) {
        GeneratePresignedUrlRequest presignedUrlRequest = new GeneratePresignedUrlRequest(bucketName, keyPrefix + path);
        URL preSignedUrl = s3Client.generatePresignedUrl(presignedUrlRequest);
        return preSignedUrl;
    }
    
}
