package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.entity.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    AuthorEntity findByName(String name);
    List<AuthorEntity> findByGenre(String genre);
    List<AuthorEntity> findByBookTitle(String title);
}
