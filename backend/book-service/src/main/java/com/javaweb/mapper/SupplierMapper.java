package com.javaweb.mapper;

import com.javaweb.entity.SupplierEntity;
import com.javaweb.model.dto.SupplierDTO;
import org.springframework.stereotype.Component;

@Component
public class SupplierMapper {
    public SupplierEntity toEntity(SupplierDTO dto){
        SupplierEntity entity = new SupplierEntity();
        entity.setId(dto.getId());
        entity.setSupplierName(dto.getSupplierName());
        return entity;
    }

    public SupplierDTO toDTO(SupplierEntity entity){
        if(entity==null) return null;
        SupplierDTO dto = new SupplierDTO();
        dto.setId(entity.getId());
        dto.setSupplierName(entity.getSupplierName());
        return dto;
    }
}
