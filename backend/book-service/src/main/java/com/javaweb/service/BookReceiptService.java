package com.javaweb.service;

import com.javaweb.model.dto.BookReceiptDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookReceiptService {
    public BookReceiptDTO addBookReceipt(BookReceiptDTO bookReceipt);
    public void deleteBookReceipt(Long id);
    public List<BookReceiptDTO> getAllBookReceipt();
    public Optional<BookReceiptDTO> getBookReceiptById(Long id);
    public List<BookReceiptDTO> getBookReceiptBySupplier(Long supplierId);
}
