package com.javaweb.controller;

import com.javaweb.model.dto.BookReceiptDetailDTO;
import com.javaweb.service.BookReceiptDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receiptDetail")
public class BookReceiptDetailController {
    @Autowired
    BookReceiptDetailService bookReceiptDetailService;

    //Endpoint lấy toàn bộ chi tiết phiếu nhập sách
    @GetMapping("/all")
    public ResponseEntity<List<BookReceiptDetailDTO>> getAllBookReceiptDetail() {
        List<BookReceiptDetailDTO> bookReceiptDetail = bookReceiptDetailService.getAllBookReceiptDetail();
        if (bookReceiptDetail.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 nếu không có chi tiết phiếu nhập sách nào
        } else {
            return ResponseEntity.ok(bookReceiptDetail); // Trả về danh sách sách
        }
    }

    //Endpoint lấy chi tiết phiếu nhập sách theo id
    @GetMapping("/{id}")
    public ResponseEntity<BookReceiptDetailDTO> getBookReceiptDetailById(@PathVariable Long id) {
        Optional<BookReceiptDetailDTO> bookReceiptDetail = bookReceiptDetailService.getBookReceiptDetailById(id);
        if (bookReceiptDetail.isPresent()) {
            return ResponseEntity.ok(bookReceiptDetail.get()); // Trả về chi tiết phiếu nhập sách nếu tìm thấy
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Endpoint xóa chi tiết phiếu nhập sách theo id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBookReceiptDetail(@PathVariable Long id) {
        bookReceiptDetailService.deleteBookReceiptDetailById(id);
        return ResponseEntity.ok().build(); // Trả về 200 nếu xóa thành công
    }

    //Endpoint thêm chi tiết phiếu nhập sách
    @PostMapping("/add")
    public ResponseEntity<BookReceiptDetailDTO> addBookReceiptDetail(@RequestBody BookReceiptDetailDTO bookReceiptDetailDTO) {
        BookReceiptDetailDTO existingbookReceiptDetail = bookReceiptDetailService.addBookReceiptDetail(bookReceiptDetailDTO);
        if (existingbookReceiptDetail != null) {
            return ResponseEntity.status(201).body(existingbookReceiptDetail);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    //Endpoint lấy chi tiết phiếu nhập sách theo ngày nhập
    @GetMapping("/importDate")
    public ResponseEntity<List<BookReceiptDetailDTO>> getBookReceiptDetailByImportDate(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<BookReceiptDetailDTO> bookReceiptDetail = bookReceiptDetailService.getBookReceiptDetailByImportDate(date);
        if (bookReceiptDetail.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.ok(bookReceiptDetail); // 200 OK với dữ liệu
        }
    }

    //Endpoint lấy chi tiết phiếu nhập sách theo id phiếu nhập sách
    @GetMapping("/receipt/{id}")
    public ResponseEntity<List<BookReceiptDetailDTO>> getBookReceiptDetailByReceiptId(@PathVariable Long id) {
        List<BookReceiptDetailDTO> bookReceiptDetail = bookReceiptDetailService.getBookReceiptDetailByReceiptId(id);
        if (bookReceiptDetail.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.ok(bookReceiptDetail); // 200 OK với dữ liệu
        }
    }

    //Endpoint lấy chi tiết phiếu nhập sách theo id phiếu nhập sách và id sách
    @GetMapping("/receipt_book/{receiptId}/{bookId}")
    public ResponseEntity<Optional<BookReceiptDetailDTO>> getBookReceiptDetailByReceiptIdAndBookId(
            @PathVariable Long receiptId,
            @PathVariable Long bookId) {
        Optional<BookReceiptDetailDTO> bookReceiptDetail = bookReceiptDetailService.
                getBookReceiptDetailByReceiptIdAndBookId(receiptId, bookId);
        if (bookReceiptDetail.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.ok(bookReceiptDetail); // 200 OK với dữ liệu
        }
    }

    //Endpoint lấy chi tiết phiếu nhập sách theo id sách
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<BookReceiptDetailDTO>> getBookReceiptDetailByBookId(@PathVariable Long bookId) {
        List<BookReceiptDetailDTO> bookReceiptDetail = bookReceiptDetailService.getBookReceiptDetailByBookId(bookId);
        if (bookReceiptDetail.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.ok(bookReceiptDetail); // 200 OK với dữ liệu
        }
    }
}
