package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.entity.GenreEntity;


public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
    GenreEntity findByName(String name);
    List<GenreEntity> findByBookTitle(String title);
    List<GenreEntity> findByAuthorName(String name);
}
