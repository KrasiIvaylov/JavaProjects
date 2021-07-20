package com.example.jsonprocessing.service.Impl;

import com.example.jsonprocessing.Constant.Global;
import com.example.jsonprocessing.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.example.jsonprocessing.Constant.Global.RESOURCES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_FILE_NAME = "categories.json";

    @Override
    public void seedCategories() throws IOException {
        String fileContent = Files
                .readString(Path.of(RESOURCES_FILE_PATH + CATEGORIES_FILE_NAME));
    }
}
