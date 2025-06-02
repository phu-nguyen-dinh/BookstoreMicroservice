package com.javaweb.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.javaweb.mapper.BookMapper;
import com.javaweb.entity.AuthorEntity;
import com.javaweb.entity.GenreEntity;
import com.javaweb.model.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.entity.BookEntity;
import com.javaweb.repository.BookRepository;
import com.javaweb.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public BookDTO addBook(BookDTO book) {
        BookEntity existingBook = bookRepository.findByTitle(book.getTitle());
        if (existingBook != null) {
            System.out.println("Book with this title already exists.");
            return null;
        }
        BookEntity bookEntity = bookMapper.toEntity(book); // ✨ chuyển DTO thành Entity
        BookEntity savedBook = bookRepository.save(bookEntity); // Lưu Entity
        return bookMapper.toDTO(savedBook); // ✨ chuyển ngược lại thành DTO để trả ra
    }


    @Override
    public BookDTO updateBook(Long id, BookDTO bookDetails) {
        BookEntity book = bookRepository.findById(id).orElse(null);
        if (book == null) {
            System.out.println("Book not found.");
            return null;
        }

        // Cập nhật các trường từ DTO
        book.setTitle(bookDetails.getTitle());

        // Gán author từ authorID
        AuthorEntity author = new AuthorEntity();
        author.setId(bookDetails.getAuthorID());
        book.setAuthor(author);

        // Cập nhật genres nếu có
        if (bookDetails.getGenreID() != null) {
            Set<GenreEntity> genres = bookDetails.getGenreID().stream().map(genreId  -> {
                GenreEntity genre = new GenreEntity();
                genre.setId(genreId);
                return genre;
            }).collect(Collectors.toSet());
            book.setGenres(genres);
        }

        book.setPrice(bookDetails.getPrice());
        book.setQuantity(bookDetails.getQuantity());

        // Lưu lại và chuyển sang DTO để trả ra
        BookEntity updatedBook = bookRepository.save(book);
        return bookMapper.toDTO(updatedBook);
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
    public Optional<BookDTO> getBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDTO);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookEntity> entities = bookRepository.findAll();
        return entities.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public List<BookDTO> getBooksByGenre(String genre) {
        List<BookEntity> books = bookRepository.findByGenres_GenreName(genre);
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getBooksByAuthor(String author) {
        List<BookEntity> books = bookRepository.findByAuthor_AuthorName(author);
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBooksByTitle(String title) {
        BookEntity book = bookRepository.findByTitle(title);
        return (book != null) ? bookMapper.toDTO(book) : null;
    }
}
