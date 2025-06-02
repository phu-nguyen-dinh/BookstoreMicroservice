package com.javaweb.service;

import java.util.List;
import java.util.Optional;

import com.javaweb.entity.GenreEntity;
import com.javaweb.model.dto.GenreDTO;

public interface GenreService { // định nghĩa các phương thức cho GenreService
    public GenreDTO addGenre(GenreDTO genre);
    public GenreDTO updateGenre(Long id, GenreDTO genreDeatails);
    public void deleteGenre(Long id);
    public Optional<GenreDTO> getGenreById(Long id);
    public List<GenreDTO> getAllGenres();
}
