package com.javaweb.controller;
import java.util.List;
import java.util.Optional;

import com.javaweb.model.dto.GenreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javaweb.service.GenreService;
import com.javaweb.entity.GenreEntity;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;
    
    // Endpoint lấy toàn bộ thể loại
    @GetMapping("/all")
    public ResponseEntity<List<GenreDTO>> getAllGenres() {
        List<GenreDTO> genres = genreService.getAllGenres();
        if (genres.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 nếu không có thể loại nào
        } else {
            return ResponseEntity.ok(genres); // Trả về danh sách thể loại
        }
    }
    // Endpoint lấy thể loại theo id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<GenreDTO>> getGenreById(@PathVariable Long id) {
        Optional<GenreDTO> genre = genreService.getGenreById(id);
        if (genre != null) {
            return ResponseEntity.ok(genre); // Trả về thể loại nếu tìm thấy
        } else {
            return ResponseEntity.notFound().build(); // Trả về 404 nếu không tìm thấy thể loại
        }
    }
    // Endpoint thêm thể loại mới
    @PostMapping("/add")
    public ResponseEntity<GenreDTO> addGenre(@RequestBody GenreDTO genre) {
        GenreDTO existingGenre = genreService.addGenre(genre);
        if (existingGenre != null) {
            return ResponseEntity.status(201).body(existingGenre); // Trả về 201 nếu thêm thành công
        } else {
            return ResponseEntity.status(400).body(null); // Trả về 400 nếu có lỗi
        }
    }
    // Endpoint cập nhật thông tin thể loại
    @PutMapping("/update/{id}")
    public ResponseEntity<GenreDTO> updateGenre(@PathVariable Long id, @RequestBody GenreDTO genreDetails) {
        GenreDTO genre = genreService.updateGenre(id, genreDetails);
        if (genre != null) {
            return ResponseEntity.ok(genre); // Trả về thể loại đã cập nhật
        } else {
            return ResponseEntity.notFound().build(); // Trả về 404 nếu không tìm thấy thể loại
        }
    }
    // Endpoint xóa thể loại
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id); // Gọi phương thức xóa thể loại
        return ResponseEntity.noContent().build(); // Trả về 204 nếu xóa thành công
    }
}
