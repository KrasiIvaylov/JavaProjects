package com.example.jsonprocessing.service;

import com.example.jsonprocessing.model.entity.User;

import java.io.IOException;

public interface UserService {
    void seedUsers() throws IOException;

    User findRandomUser();
}
