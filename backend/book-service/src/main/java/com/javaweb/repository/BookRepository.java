package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findByTitle(String title);
    List<BookEntity> findByAuthor_AuthorName(String authorName);
    List<BookEntity> findByGenres_GenreName(String genreName);
}