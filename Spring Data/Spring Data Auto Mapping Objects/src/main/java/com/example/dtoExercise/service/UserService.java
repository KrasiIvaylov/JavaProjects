package com.example.dtoExercise.service;


import com.example.dtoExercise.model.dto.UserLoginDto;
import com.example.dtoExercise.model.dto.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);
}
