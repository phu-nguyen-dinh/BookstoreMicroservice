package com.javaweb.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.javaweb.entity.AuthorEntity;
import com.javaweb.mapper.BookMapper;
import com.javaweb.mapper.GenreMapper;
import com.javaweb.model.dto.GenreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.entity.BookEntity;
import com.javaweb.entity.GenreEntity;
import com.javaweb.repository.BookRepository;
import com.javaweb.repository.GenreRepository;
import com.javaweb.service.GenreService;  

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    GenreMapper genreMapper;

    @Override
    public GenreDTO addGenre(GenreDTO genre) {
        GenreEntity existingGenre = genreRepository.findByGenreName(genre.getGenreName());
        if (existingGenre != null) {
            System.out.println("Genre with this name already exists.");
            return null;
        }
        GenreEntity genreEntity =  genreMapper.toEntity(genre);
        GenreEntity savedGenre = genreRepository.save(genreEntity);
        return genreMapper.toDTO(savedGenre);
    }

    @Override
    public GenreDTO updateGenre(Long id, GenreDTO genreDeatails) {
        GenreEntity existingGenre = genreRepository.findById(id).orElse(null);
        if (existingGenre == null) {
            System.out.println("Genre not found.");
            return null;
        }
        existingGenre.setGenreName(genreDeatails.getGenreName());
        GenreEntity updatedGenre = genreRepository.save(existingGenre);
        return genreMapper.toDTO(updatedGenre);
    }

    @Override
    public void deleteGenre(Long id) {
        GenreEntity existingGenre = genreRepository.findById(id).orElse(null);
        if (existingGenre == null) {
            System.out.println("Genre not found.");
            return;
        }
        // Kiểm tra xem thể loại có sách nào không
        List<BookEntity> books = bookRepository.findByGenres_GenreName(existingGenre.getGenreName());
        if (books != null && !books.isEmpty()) {
            System.out.println("Cannot delete genre with existing books.");
        } else {
            genreRepository.delete(existingGenre);
            System.out.println("Genre deleted successfully.");
        }
    }

    @Override
    public Optional<GenreDTO> getGenreById(Long id) {
        return genreRepository.findById(id)
                .map(genreMapper::toDTO);
    }

    @Override
    public List<GenreDTO> getAllGenres() {
        List<GenreEntity> entities = genreRepository.findAll();
        return entities.stream()
                .map(genreMapper::toDTO)
                .collect(Collectors.toList());
    }

}
