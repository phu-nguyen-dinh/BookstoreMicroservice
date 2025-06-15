package com.javaweb.service;

import com.javaweb.model.dto.BookReceiptDetailDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookReceiptDetailService {
    public Optional<BookReceiptDetailDTO> getBookReceiptDetailByReceiptIdAndBookId(Long receiptId, Long bookId);
    public List<BookReceiptDetailDTO> getBookReceiptDetailByReceiptId(Long id);
    public void deleteBookReceiptDetailById(Long id);
    public BookReceiptDetailDTO addBookReceiptDetail(BookReceiptDetailDTO bookReceiptDetailDTO);
    public List<BookReceiptDetailDTO> getBookReceiptDetailByImportDate(LocalDate importDate);
    public List<BookReceiptDetailDTO> getAllBookReceiptDetail();
    public Optional<BookReceiptDetailDTO> getBookReceiptDetailById(Long id);
    public List<BookReceiptDetailDTO> getBookReceiptDetailByBookId(Long bookId);
}
