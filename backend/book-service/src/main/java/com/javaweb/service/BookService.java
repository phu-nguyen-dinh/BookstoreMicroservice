package com.javaweb.service;

import java.util.List;
import java.util.Optional;

import com.javaweb.model.dto.BookDTO;

public interface BookService {
    public BookDTO addBook(BookDTO book);
    public BookDTO updateBook(Long id, BookDTO bookDetails);
    public void deleteBook(Long id);    
    public Optional<BookDTO> getBookById(Long id);
    public List<BookDTO> getAllBooks();
    public List<BookDTO> getBooksByGenre(String genre);
    public List<BookDTO> getBooksByAuthor(String author);
    public BookDTO getBooksByTitle(String title);
}
