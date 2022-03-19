package com.example.jsonprocessing.service.Impl;

import com.example.jsonprocessing.model.dto.UserSeedDto;
import com.example.jsonprocessing.model.entity.User;
import com.example.jsonprocessing.repository.UserRepository;
import com.example.jsonprocessing.service.UserService;
import com.example.jsonprocessing.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.jsonprocessing.Constant.Global.RESOURCES_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {

    private static final String USERS_FILE_NAME = "users.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }


    @Override
    public void seedUsers() throws IOException {
        if (userRepository.count() == 0) {
            Arrays.stream(gson
                    .fromJson(
                            Files.readString(Path.of(RESOURCES_FILE_PATH + USERS_FILE_NAME)),
                            UserSeedDto[].class))
                    .filter(validationUtil::isValid)
                    .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                    .forEach(userRepository::save);
        }
    }

    @Override
    public User findRandomUser() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, userRepository.count()  + 1);

        return userRepository
                .findById(randomId)
                .orElse(null);
    }
}
