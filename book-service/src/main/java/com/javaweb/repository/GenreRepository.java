package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.model.dto.GenreDTO;

public interface GenreRepository extends JpaRepository<GenreDTO, Long> { // dể lưu trữ các đối tượng GenreDTO trong cơ sở dữ liệu
    GenreDTO findByName(String name);
    List<GenreDTO> findByBookTitle(String title);
    List<GenreDTO> findByAuthorName(String name);
}
