package com.javaweb.service.impl;

import org.springframework.stereotype.Service;

import com.javaweb.service.GenreService;  

@Service
public class GenreServiceImpl implements GenreService {
    @Override
    public void addGenre() {
        System.out.println("Genre added successfully.");
    }

    @Override
    public void updateGenre() {
        System.out.println("Genre updated successfully.");
    }

    @Override
    public void deleteGenre() {
        System.out.println("Genre deleted successfully.");
    }

    @Override
    public void getGenreById() {
        System.out.println("Genre retrieved by ID successfully.");
    }

    @Override
    public void getAllGenres() {
        System.out.println("All genres retrieved successfully.");
    }

}
