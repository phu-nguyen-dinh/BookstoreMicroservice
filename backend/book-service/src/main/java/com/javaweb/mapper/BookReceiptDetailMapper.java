package com.javaweb.mapper;

import com.javaweb.entity.BookEntity;
import com.javaweb.entity.BookReceiptDetailEntity;
import com.javaweb.entity.BookReceiptEntity;
import com.javaweb.model.dto.BookReceiptDTO;
import com.javaweb.model.dto.BookReceiptDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class BookReceiptDetailMapper {

    public BookReceiptDetailEntity toEntity(BookReceiptDetailDTO dto) {
        BookReceiptDetailEntity entity = new BookReceiptDetailEntity();

        entity.setId(dto.getId());

        entity.setImportDate(dto.getImportDate());
        entity.setImportPrice(dto.getImportPrice());
        entity.setQuantity(dto.getQuantity());

        BookReceiptEntity bookReceiptEntity = new BookReceiptEntity();
        bookReceiptEntity.setId(dto.getReceiptId());
        entity.setBookReceipt(bookReceiptEntity);

        // Gắn quan hệ với Book
        BookEntity book = new BookEntity();
        book.setId(dto.getBookId());
        entity.setBook(book);

        return entity;
    }

    public BookReceiptDetailDTO toDTO(BookReceiptDetailEntity entity) {
        BookReceiptDetailDTO dto = new BookReceiptDetailDTO();

        dto.setId(entity.getId());
        dto.setImportDate(entity.getImportDate());
        dto.setImportPrice(entity.getImportPrice());
        dto.setQuantity(entity.getQuantity());

        dto.setReceiptId(entity.getBookReceipt().getId());
        dto.setBookId(entity.getBook().getId());

        return dto;
    }
}

