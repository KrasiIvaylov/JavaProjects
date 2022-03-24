package com.example.springintroex.service;

import com.example.springintroex.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORIES_FILE_PATH = "src/main/resources/files/categories.txt";

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        List<String> rows = Files.readAllLines(Path.of(CATEGORIES_FILE_PATH));
    }
}
