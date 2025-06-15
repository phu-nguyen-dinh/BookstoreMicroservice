package com.javaweb.service.impl;

import com.javaweb.entity.BookReceiptEntity;
import com.javaweb.mapper.BookReceiptMapper;
import com.javaweb.model.dto.BookReceiptDTO;
import com.javaweb.repository.BookReceiptRepository;
import com.javaweb.repository.BookRepository;
import com.javaweb.service.BookReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookReceiptServiceImpl implements BookReceiptService {
    @Autowired
    private BookReceiptRepository bookReceiptRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookReceiptMapper bookReceiptMapper;

    @Override
    public BookReceiptDTO addBookReceipt(BookReceiptDTO bookReceipt) {
        //chuyển DTO sang Entity
        BookReceiptEntity bookReceiptEntity = bookReceiptMapper.toEntity(bookReceipt);
        // Lưu entity vào database
        BookReceiptEntity savedBookReceiptEntity = bookReceiptRepository.save(bookReceiptEntity);
        // Chuyển entity đã lưu sang DTO và trả về
        return bookReceiptMapper.toDTO(savedBookReceiptEntity);
    }

    @Override
    public void deleteBookReceipt(Long id) {
        BookReceiptEntity existingBookReceipt = bookReceiptRepository.findById(id).orElse(null);
        if (existingBookReceipt == null) {
            System.out.println("Book receipt not found.");
            return;
        }
        bookReceiptRepository.delete(existingBookReceipt);
    }

    @Override
    public List<BookReceiptDTO> getAllBookReceipt() {
        List<BookReceiptEntity> entities = bookReceiptRepository.findAll();
        return entities.stream()
                .map(bookReceiptMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookReceiptDTO> getBookReceiptById(Long id) {
        return bookReceiptRepository.findById(id)
                .map(bookReceiptMapper::toDTO);
    }

    @Override
    public List<BookReceiptDTO> getBookReceiptBySupplier(Long supplierId) {
        List<BookReceiptEntity> entities = bookReceiptRepository.findBySupplierId(supplierId);
        if(entities==null){
            System.out.println("There is no book receipt with id: "+supplierId);
            return null;
        }
        return entities.stream()
                .map(bookReceiptMapper::toDTO)
                .collect(Collectors.toList());
    }
}
