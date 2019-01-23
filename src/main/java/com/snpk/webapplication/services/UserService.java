package com.snpk.webapplication.services;

import com.snpk.webapplication.model.User;


public interface UserService {

    void save(User user);
    User findByUsername(String username);
    //User findByEmail(String email);
}