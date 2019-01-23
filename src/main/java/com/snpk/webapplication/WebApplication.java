package com.snpk.webapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//@EnableOAuth2Sso
public class WebApplication{
   
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}