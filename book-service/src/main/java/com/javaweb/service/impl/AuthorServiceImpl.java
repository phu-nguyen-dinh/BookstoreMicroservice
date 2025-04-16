package com.javaweb.service.impl;

import org.springframework.stereotype.Service;

import com.javaweb.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    public void addAuthor() {
        System.out.println("Author added successfully.");
    }

    @Override
    public void updateAuthor() {
        System.out.println("Author updated successfully.");
    }

    @Override
    public void deleteAuthor() {
        System.out.println("Author deleted successfully.");
    }

    @Override
    public void getAuthorById() {
        System.out.println("Author retrieved by ID successfully.");
    }

    @Override
    public void getAllAuthors() {
        System.out.println("All authors retrieved successfully.");
    }

    @Override
    public void getAuthorsByGenre() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorsByGenre'");
    }

}
