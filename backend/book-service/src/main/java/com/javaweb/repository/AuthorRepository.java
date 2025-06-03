package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.AuthorEntity;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> { // để truy cập vào cơ sở dữ liệu
    AuthorEntity findByAuthorName(String authorName);
   // List<AuthorEntity> findByGenre(String genre);
   // List<AuthorEntity> findByBookTitle(String title);
}
