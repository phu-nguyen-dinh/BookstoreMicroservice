package com.javaweb.service.impl;

import org.springframework.stereotype.Service;

import com.javaweb.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public void addBook() {
        
        System.out.println("Book added successfully.");
    }

    @Override
    public void updateBook() {
        
        System.out.println("Book updated successfully.");
    }

    @Override
    public void deleteBook() {
        
        System.out.println("Book deleted successfully.");
    }

    @Override
    public void getBookById() {
        
        System.out.println("Book retrieved by ID successfully.");
    }

    @Override
    public void getAllBooks() {
        
        System.out.println("All books retrieved successfully.");
    }

    @Override
    public void getBooksByGenre() {
        
        System.out.println("Books retrieved by genre successfully.");
    }

    @Override
    public void getBooksByAuthor() {
        
        System.out.println("Books retrieved by author successfully.");
    }

}
