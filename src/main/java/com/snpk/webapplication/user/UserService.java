package com.snpk.webapplication.user;

public interface UserService {

    void save(User user);
    User findByUsername(String username);
    //User findByEmail(String email);
}