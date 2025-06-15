package com.javaweb.service.impl;

import com.javaweb.entity.BookEntity;
import com.javaweb.entity.BookReceiptDetailEntity;
import com.javaweb.entity.BookReceiptEntity;
import com.javaweb.mapper.BookReceiptDetailMapper;
import com.javaweb.model.dto.BookReceiptDetailDTO;
import com.javaweb.repository.BookReceiptDetailRepository;
import com.javaweb.repository.BookReceiptRepository;
import com.javaweb.repository.BookRepository;
import com.javaweb.service.BookReceiptDetailService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookReceiptDetailServiceImpl implements BookReceiptDetailService {
    @Autowired
    private BookReceiptDetailMapper bookReceiptDetailMapper;
    @Autowired
    private BookReceiptDetailRepository bookReceiptDetailRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookReceiptRepository bookReceiptRepository;

    @Override
    public Optional<BookReceiptDetailDTO> getBookReceiptDetailByReceiptIdAndBookId(Long receiptId, Long bookId) {
        return bookReceiptDetailRepository
            .findByBookReceiptIdAndBookId(receiptId, bookId)
                .map(bookReceiptDetailMapper::toDTO);
    }

    @Override
    public List<BookReceiptDetailDTO> getBookReceiptDetailByReceiptId(Long id) {
        List<BookReceiptDetailEntity> details = bookReceiptDetailRepository.findByBookReceiptId(id);
        return details.stream()
                .map(bookReceiptDetailMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookReceiptDetailDTO> getBookReceiptDetailById(Long id) {
        return bookReceiptDetailRepository.findById(id)
                .map(bookReceiptDetailMapper::toDTO);
    }

    @Override
    public List<BookReceiptDetailDTO> getBookReceiptDetailByBookId(Long bookId) {
        List<BookReceiptDetailEntity> details = bookReceiptDetailRepository.findByBookId(bookId);
        return details.stream()
                .map(bookReceiptDetailMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBookReceiptDetailById(Long id) {
        if (!bookReceiptDetailRepository.existsById(id)) {
            throw new EntityNotFoundException("BookReceiptDetail with id " + id + " not found");
        }
        bookReceiptDetailRepository.deleteById(id);
    }

    @Override
    public BookReceiptDetailDTO addBookReceiptDetail(BookReceiptDetailDTO bookReceiptDetailDTO) {
        BookReceiptDetailEntity entity = new BookReceiptDetailEntity();

        BookEntity book = bookRepository.findById(bookReceiptDetailDTO.getBookId())
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        BookReceiptEntity bookReceipt = bookReceiptRepository.findById(bookReceiptDetailDTO.getReceiptId())
                .orElseThrow(() -> new EntityNotFoundException("Book receipt not found"));

        entity.setImportDate(bookReceiptDetailDTO.getImportDate());
        entity.setBook(book);
        entity.setBookReceipt(bookReceipt);
        entity.setQuantity(bookReceiptDetailDTO.getQuantity());
        entity.setImportPrice(bookReceiptDetailDTO.getImportPrice());

        BookReceiptDetailEntity saved = bookReceiptDetailRepository.save(entity);
        return bookReceiptDetailMapper.toDTO(saved);
    }

    @Override
    public List<BookReceiptDetailDTO> getBookReceiptDetailByImportDate(LocalDate importDate) {
        List<BookReceiptDetailEntity> details = bookReceiptDetailRepository.findByImportDate(importDate);
        return details.stream()
                .map(bookReceiptDetailMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookReceiptDetailDTO> getAllBookReceiptDetail() {
        List<BookReceiptDetailEntity> entities = bookReceiptDetailRepository.findAll();
        return entities.stream()
                .map(bookReceiptDetailMapper::toDTO)
                .collect(Collectors.toList());
    }
}
