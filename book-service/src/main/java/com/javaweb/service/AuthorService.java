package com.javaweb.service;

import java.util.List;
import java.util.Optional;

import com.javaweb.entity.AuthorEntity;
import com.javaweb.model.dto.AuthorDTO;

public interface AuthorService { // định nghĩa các phương thức cho AuthorService
    AuthorDTO addAuthor(AuthorDTO author);
    AuthorDTO updateAuthor(Long id, AuthorDTO authorDetails);
    void deleteAuthor(Long id);
    Optional<AuthorDTO> getAuthorById(Long id);
    List<AuthorDTO> getAllAuthors();
   // List<AuthorEntity> getAuthorsByGenre(String genre);
}
