package com.example.springintroex.service;

import com.example.springintroex.repository.CategoryRepository;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;
}
