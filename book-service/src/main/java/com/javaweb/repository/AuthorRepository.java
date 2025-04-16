package com.javaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.model.dto.AuthorDTO;

public interface AuthorRepository extends JpaRepository<AuthorDTO, Long> { // dể lưu trữ các đối tượng AuthorDTO trong cơ sở dữ liệu
    AuthorDTO findByName(String name);
    List<AuthorDTO> findByGenre(String genre);
    List<AuthorDTO> findByBookTitle(String title);
}
