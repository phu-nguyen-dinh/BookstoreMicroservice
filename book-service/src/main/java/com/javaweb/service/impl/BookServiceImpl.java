package com.javaweb.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.entity.BookEntity;
import com.javaweb.repository.BookRepository;
import com.javaweb.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookEntity addBook(BookEntity book) {
        BookEntity existingBook = bookRepository.findByTitle(book.getTitle());
        if (existingBook != null) {
            System.out.println("Book with this title already exists.");
            return null;
        }
        BookEntity savedBook = bookRepository.save(book);   
        return savedBook;
    }

    @Override
    public BookEntity updateBook(Long id, BookEntity bookDetails) {   
        BookEntity book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            System.out.println("Book not found.");
            return null;
        }
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPrice(bookDetails.getPrice());
        book.setQuantity(bookDetails.getQuantity());
        BookEntity updatedBook = bookRepository.save(book);
        return updatedBook;
    }

    @Override
    public void deleteBook( Long id) {      
        BookEntity book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        bookRepository.delete(book);
        System.out.println("Book deleted successfully.");
    }

    @Override
    public Optional<BookEntity> getBookById(Long id) {
        BookEntity book = bookRepository.findById(id).orElse(null);
        return Optional.ofNullable(book);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<BookEntity> getBooksByGenre(String genre) { 
        List<BookEntity> books = bookRepository.findByGenre(genre);
        return books;
    }

    @Override
    public List<BookEntity> getBooksByAuthor(String author) {
        List<BookEntity> books = bookRepository.findByAuthor(author);
        return books;
    }

    @Override
    public BookEntity getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

}
