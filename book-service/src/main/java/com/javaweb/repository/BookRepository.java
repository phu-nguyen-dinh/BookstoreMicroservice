package com.javaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.model.dto.BookDTO;

@Repository
public interface BookRepository extends JpaRepository<BookDTO, Long> { // dể lưu trữ các đối tượng BookDTO trong cơ sở dữ liệu
    BookDTO findByTitle(String title); 
    BookDTO findByAuthor(String author);
    BookDTO findByGenre(String genre);
}