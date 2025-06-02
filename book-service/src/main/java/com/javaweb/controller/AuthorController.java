package com.javaweb.controller;
import java.util.List;
import java.util.Optional;

import com.javaweb.model.dto.AuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javaweb.entity.AuthorEntity;
import com.javaweb.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    
    // Endpoint lấy toàn bộ tác giả
    @GetMapping("/all")
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        List<AuthorDTO> authors = authorService.getAllAuthors();
        if (authors.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 nếu không có tác giả nào
        } else {
            return ResponseEntity.ok(authors); // Trả về danh sách tác giả
        }
    }

    // Endpoint lấy tác giả theo id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<AuthorDTO>> getAuthorById(@PathVariable Long id) {
        Optional<AuthorDTO> author = authorService.getAuthorById(id);
        if (author != null) {
            return ResponseEntity.ok(author); // Trả về tác giả nếu tìm thấy
        } else {
            return ResponseEntity.notFound().build(); // Trả về 404 nếu không tìm thấy tác giả
        }
    }

    // // Endpoint lấy tác giả theo thể loại
    // @GetMapping("/genre/{genre}")
    // public ResponseEntity<List<AuthorEntity>> getAuthorsByGenre(@PathVariable String genre) {
    //     List<AuthorEntity> authors = authorService.getAuthorsByGenre(genre);
    //     if (authors.isEmpty()) {
    //         return ResponseEntity.noContent().build(); // Trả về 204 nếu không có tác giả nào
    //     } else {
    //         return ResponseEntity.ok(authors); // Trả về danh sách tác giả theo thể loại
    //     }
    // }

    // Endpoint thêm tác giả mới
    @PostMapping("/add")
    public ResponseEntity<AuthorDTO> addAuthor(@RequestBody AuthorDTO author) {
        AuthorDTO existingAuthor = authorService.addAuthor(author);
        if (existingAuthor != null) {
            return ResponseEntity.status(201).body(existingAuthor); // Trả về 201 nếu thêm thành công
        } else {
            return ResponseEntity.status(400).body(null); // Trả về 400 nếu có lỗi
        }
    }

    // Endpoint cập nhật thông tin tác giả
    @PutMapping("/update/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDetails) {
        AuthorDTO author = authorService.updateAuthor(id, authorDetails);
        if (author != null) {
            return ResponseEntity.ok(author); // Trả về tác giả đã cập nhật
        } else {
            return ResponseEntity.notFound().build(); // Trả về 404 nếu không tìm thấy tác giả
        }
    }

    // Endpoint xóa tác giả theo id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok().build(); // Trả về 200 nếu xóa thành công
    }
    
}
