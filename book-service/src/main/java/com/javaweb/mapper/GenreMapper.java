package com.javaweb.mapper;

import com.javaweb.entity.GenreEntity;
import com.javaweb.model.dto.GenreDTO;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {
    public GenreEntity toEntity(GenreDTO dto){
        if(dto==null) return null;

        GenreEntity entity = new GenreEntity();
        entity.setId(dto.getId());
        entity.setGenreName(dto.getGenreName());

        return entity;
    }

    public GenreDTO toDTO(GenreEntity entity){
        if(entity==null) return null;

        GenreDTO dto = new GenreDTO();
        dto.setId(entity.getId());
        dto.setGenreName(entity.getGenreName());

        return dto;
    }
}
