package com.javaweb.mapper;

import com.javaweb.entity.RegulationEntity;
import com.javaweb.model.dto.RegulationDTO;
import org.springframework.stereotype.Component;

@Component
public class RegulationMapper {
    public RegulationDTO toDTO(RegulationEntity entity){
        if(entity==null) return null;

        RegulationDTO dto = new RegulationDTO();
        dto.setId(entity.getId());
        dto.setContent(entity.getContent());
        dto.setDateIssued(entity.getDateIssued());

        return dto;
    }

    public RegulationEntity toEntity(RegulationDTO dto){
        RegulationEntity entity = new RegulationEntity();
        entity.setId(dto.getId());
        entity.setContent(dto.getContent());
        entity.setDateIssued(dto.getDateIssued());

        return entity;
    }
}
