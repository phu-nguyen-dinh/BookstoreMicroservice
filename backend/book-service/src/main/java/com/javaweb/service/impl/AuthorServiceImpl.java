package com.javaweb.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.javaweb.mapper.AuthorMapper;
import com.javaweb.mapper.BookMapper;
import com.javaweb.model.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.entity.AuthorEntity;
import com.javaweb.entity.BookEntity;
import com.javaweb.entity.GenreEntity;
import com.javaweb.repository.AuthorRepository;
import com.javaweb.repository.BookRepository;
import com.javaweb.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository; // sử dụng AuthorRepository để truy cập dữ liệu từ bảng authors trong cơ sở dữ liệu
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public AuthorDTO addAuthor(AuthorDTO author) {
        AuthorEntity existingAuthor = authorRepository.findByAuthorName(author.getAuthorName());
        if (existingAuthor != null) {
            System.out.println("Author with this name already exists.");
            return null;
        }
        AuthorEntity authorEntity = authorMapper.toEntity(author);
        AuthorEntity savedAuthor = authorRepository.save(authorEntity);
        return authorMapper.toDTO(savedAuthor);
    }

    @Override
    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDetails) {
        AuthorEntity existingAuthor = authorRepository.findById(id).orElse(null);
        if (existingAuthor == null) {
            System.out.println("Author not found.");
            return null;
        }
        existingAuthor.setAuthorName(authorDetails.getAuthorName());

        AuthorEntity updatedAuthor = authorRepository.save(existingAuthor);
        return authorMapper.toDTO(updatedAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        AuthorEntity existingAuthor = authorRepository.findById(id).orElse(null);
        if (existingAuthor == null) {
            System.out.println("Author not found.");
            return;
        }
        // Kiểm tra xem tác giả có sách nào không
        List<BookEntity> books = bookRepository.findByAuthor_AuthorName(existingAuthor.getAuthorName());
        if (books != null && !books.isEmpty()) {
            System.out.println("Cannot delete author with existing books.");
        }
        else {
            authorRepository.delete(existingAuthor);
            System.out.println("Author deleted successfully.");
        }
    }

    @Override
    public Optional<AuthorDTO> getAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(authorMapper::toDTO);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<AuthorEntity> entities = authorRepository.findAll();
        return entities.stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

    // @Override
    // public List<AuthorEntity> getAuthorsByGenre(String genre) {
    //     List<AuthorEntity> authors = AuthorRepository.findByGenre(genre);
    //     return authors;
    // }

}
