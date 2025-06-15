package com.javaweb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "book_receipt_detail")
public class BookReceiptDetailEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "receipt_id", nullable = false)
    private BookReceiptEntity bookReceipt;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

    @Column(name = "import_date", nullable = false)
    private LocalDate importDate;

    @Column(name = "import_price", nullable = false)
    private Double importPrice;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
