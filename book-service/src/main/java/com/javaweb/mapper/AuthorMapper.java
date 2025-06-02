package com.javaweb.mapper;

import com.javaweb.entity.AuthorEntity;
import com.javaweb.model.dto.AuthorDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorEntity toEntity(AuthorDTO dto) {
        if (dto == null) return null;

        AuthorEntity entity = new AuthorEntity();
        entity.setId(dto.getId());
        entity.setAuthorName(dto.getAuthorName());
        return entity;
    }

    public AuthorDTO toDTO(AuthorEntity entity) {
        if (entity == null) return null;

        AuthorDTO dto = new AuthorDTO();
        dto.setId(entity.getId());
        dto.setAuthorName(entity.getAuthorName());
        return dto;
    }
}
