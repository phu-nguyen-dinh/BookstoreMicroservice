package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class BookReceiptDetailDTO {
    private Long id;
    private Long receiptId;
    private Long bookId;

    private LocalDate importDate;
    private Double importPrice;
    private Integer quantity;
}
