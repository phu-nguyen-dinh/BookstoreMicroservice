package com.javaweb.controller;
import java.util.List;
import java.util.Optional;

import com.javaweb.model.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.javaweb.entity.BookEntity;
import com.javaweb.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {  
    @Autowired
    private BookService bookService;

    //Endpoint lấy toàn bộ sách
    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> books = bookService.getAllBooks();
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 nếu không có sách nào
        } else {
            return ResponseEntity.ok(books); // Trả về danh sách sách
        }
    }

    //Endpoint lấy sách theo id
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Optional<BookDTO> book = bookService.getBookById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get()); // Trả về sách nếu tìm thấy
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //Endpoint thêm sách mới
    @PostMapping("/add")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO book) {
        BookDTO existingBook = bookService.addBook(book);
        if (existingBook != null) {
            return ResponseEntity.status(201).body(existingBook);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }
    
    //Endpoint cập nhật thông tin sách
    @PutMapping("/update/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookdetails) {
        BookDTO book = bookService.updateBook(id, bookdetails);
        if (book != null) {
            return ResponseEntity.ok(book); // Trả về sách đã cập nhật
        } else {
            return ResponseEntity.notFound().build(); // Trả về 404 nếu không tìm thấy sách
        }
    }

    //Endpoint xóa sách theo id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build(); // Trả về 200 nếu xóa thành công
    }
    
    //Endpoint lấy sách theo thể loại
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<BookDTO>> getBooksByGenre(@PathVariable String genre) {
        List<BookDTO> books = bookService.getBooksByGenre(genre);
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 nếu không có sách nào
        } else {
            return ResponseEntity.ok(books); // Trả về danh sách sách
        }
    }

    //Endpoint lấy sách theo tác giả
    @GetMapping("/author/{authorName}")
    public ResponseEntity<List<BookDTO>> getBooksByAuthor(@PathVariable String authorName) {
        List<BookDTO> books = bookService.getBooksByAuthor(authorName);
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 nếu không có sách nào
        } else {
            return ResponseEntity.ok(books); // Trả về danh sách sách
        }
    }
    //Endpoint tìm kiếm sách theo title
    @GetMapping("/title/{title}")
    public ResponseEntity<BookDTO> getBooksByTitle(@PathVariable String title) {
        BookDTO books = bookService.getBooksByTitle(title);
        if (books != null) {
            return ResponseEntity.ok(books); // Trả về sách nếu tìm thấy
        } else {
            return ResponseEntity.notFound().build(); // Trả về 404 nếu không tìm thấy sách
        }
    }
}
