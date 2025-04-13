package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.model.dto.BookDTO;

@Repository
public interface BookRepository extends JpaRepository<BookDTO, Long> {
 
} 