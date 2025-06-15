package com.javaweb.controller;

import com.javaweb.model.dto.BookReceiptDTO;
import com.javaweb.service.BookReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receipts")
public class BookReceiptController {
    @Autowired
    private BookReceiptService bookReceiptService;

    //Endpoint lấy toàn bộ phiếu nhập sách
    @GetMapping("/all")
    public ResponseEntity<List<BookReceiptDTO>> getAllBookReceipt() {
        List<BookReceiptDTO> bookReceipts = bookReceiptService.getAllBookReceipt();
        if (bookReceipts.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 nếu không có phiếu nhập sách nào
        } else {
            return ResponseEntity.ok(bookReceipts); // Trả về danh sách phiếu nhập sách
        }
    }

    //Endpoint lấy phiếu nhập sách theo id
    @GetMapping("/{id}")
    public ResponseEntity<BookReceiptDTO> getBookReceiptById(@PathVariable Long id) {
        Optional<BookReceiptDTO> book = bookReceiptService.getBookReceiptById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get()); // Trả về phiếu nhập sách nếu tìm thấy
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Endpoint xóa phiếu nhập sách theo id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBookReceipt(@PathVariable Long id) {
        bookReceiptService.deleteBookReceipt(id);
        return ResponseEntity.ok().build(); // Trả về 200 nếu xóa thành công
    }

    //Endpoint thêm phiếu nhập sách
    @PostMapping("/add")
    public ResponseEntity<BookReceiptDTO> addBookReceipt(@RequestBody BookReceiptDTO bookReceiptDTO) {
        BookReceiptDTO existingBookReceipt = bookReceiptService.addBookReceipt(bookReceiptDTO);
        if (existingBookReceipt != null) {
            return ResponseEntity.status(201).body(existingBookReceipt);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    //Endpoint lấy phiếu nhập sách theo Id nhà cung cấp
    @GetMapping("/supplier/{id}")
    public ResponseEntity<List<BookReceiptDTO>> getBookReceiptBySupplierId(@PathVariable Long id) {
        List<BookReceiptDTO> bookReceipts = bookReceiptService.getBookReceiptBySupplier(id);
        if (bookReceipts.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 nếu không có phiếu nhập sách nào
        } else {
            return ResponseEntity.ok(bookReceipts); // Trả về danh sách phiếu nhập sách
        }
    }
}
