package com.javaweb.mapper;

import com.javaweb.entity.BookReceiptEntity;
import com.javaweb.entity.SupplierEntity;
import com.javaweb.model.dto.BookReceiptDTO;
import org.springframework.stereotype.Component;

@Component
public class BookReceiptMapper {
    public BookReceiptEntity toEntity(BookReceiptDTO dto) {
        BookReceiptEntity entity = new BookReceiptEntity();
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }

        // quan hệ với supplierentity
        SupplierEntity supplier = new SupplierEntity();
        supplier.setId(dto.getSupplierId());
        entity.setSupplier(supplier);

        return entity;
    }


    public BookReceiptDTO toDTO(BookReceiptEntity entity) {
        BookReceiptDTO dto = new BookReceiptDTO();
        dto.setId(entity.getId());

        // quan hệ với SupplierEntity
        dto.setSupplierId(entity.getSupplier().getId());

        return dto;
    }

}
