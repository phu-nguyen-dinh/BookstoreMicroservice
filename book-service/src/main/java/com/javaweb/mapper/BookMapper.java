package com.javaweb.mapper;

import com.javaweb.entity.AuthorEntity;
import com.javaweb.entity.BookEntity;
import com.javaweb.entity.GenreEntity;
import com.javaweb.model.dto.BookDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public BookEntity toEntity(BookDTO dto) {
        BookEntity entity = new BookEntity();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());

        // Mapping Author
        AuthorEntity author = new AuthorEntity();
        author.setId(dto.getAuthorID());
        entity.setAuthor(author);

        // Mapping Genres
        Set<GenreEntity> genres = dto.getGenreID().stream().map(id -> {
            GenreEntity genre = new GenreEntity();
            genre.setId(id);
            return genre;
        }).collect(Collectors.toSet());
        entity.setGenres(genres);

        return entity;
    }

    public BookDTO toDTO(BookEntity entity) {
        BookDTO dto = new BookDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());

        if (entity.getAuthor() != null) {
            dto.setAuthorID(entity.getAuthor().getId());
        }

        if (entity.getGenres() != null) {
            dto.setGenreID(entity.getGenres().stream()
                    .map(GenreEntity::getId)
                    .collect(Collectors.toList()));
        }
        return dto;
    }
}

