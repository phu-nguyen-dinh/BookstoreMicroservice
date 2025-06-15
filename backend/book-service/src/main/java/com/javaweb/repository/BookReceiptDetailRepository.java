package com.javaweb.repository;

import com.javaweb.entity.BookReceiptDetailEntity;
import com.javaweb.model.dto.BookReceiptDetailDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookReceiptDetailRepository extends JpaRepository<BookReceiptDetailEntity, Long> {
    Optional<BookReceiptDetailEntity> findByBookReceiptIdAndBookId(Long receiptId, Long bookId);
    List<BookReceiptDetailEntity> findByBookReceiptId(Long receiptId);
    @Query("SELECT r FROM BookReceiptDetailEntity r WHERE FUNCTION('DATE', r.importDate) = :importDate")
    List<BookReceiptDetailEntity> findByImportDate(@Param("importDate") LocalDate importDate);
    Optional<BookReceiptDetailEntity> findById(Long id);
    List<BookReceiptDetailEntity> findAll();
    List<BookReceiptDetailEntity> findByBookId(Long id);
}
