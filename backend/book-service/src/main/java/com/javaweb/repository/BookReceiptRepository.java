package com.javaweb.repository;

import com.javaweb.entity.BookReceiptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookReceiptRepository extends JpaRepository<BookReceiptEntity, Long> {
    Optional<BookReceiptEntity> findById(Long id);
    List<BookReceiptEntity> findBySupplierId(Long supplierId);
    List<BookReceiptEntity> findAll();
}
