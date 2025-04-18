package com.javaweb.service;

import java.util.List;
import java.util.Optional;

import com.javaweb.entity.BookEntity;

public interface BookService { // định nghĩa các phương thức cho BookService
    public BookEntity addBook(BookEntity book);
    public BookEntity updateBook(Long id, BookEntity bookDetails);
    public void deleteBook(Long id);    
    public Optional<BookEntity> getBookById(Long id);
    public List<BookEntity> getAllBooks();
    public List<BookEntity> getBooksByGenre(String genre);
    public List<BookEntity> getBooksByAuthor(String author);
    public BookEntity getBooksByTitle(String title);
}
