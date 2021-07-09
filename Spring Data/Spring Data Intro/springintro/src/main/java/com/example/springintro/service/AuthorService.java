package com.example.springintro.service;

import com.example.springintro.model.entity.Author;

import java.io.IOException;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();
}
