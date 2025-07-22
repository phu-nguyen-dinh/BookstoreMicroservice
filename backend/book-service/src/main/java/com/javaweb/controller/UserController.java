package com.javaweb.controller;

import com.javaweb.model.dto.UserDTO;
import com.javaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO user){
        UserDTO users = userService.addUser(user);
        if (users != null) {
            return ResponseEntity.status(201).body(users); // Trả về 201 nếu thêm thành công
        } else {
            return ResponseEntity.status(400).body(null); // Trả về 400 nếu có lỗi
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<UserDTO> users = userService.getAllUser();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 nếu không có
        } else {
            return ResponseEntity.ok(users); // Trả về danh sách
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDTO>> getUserById(@PathVariable Long id){
        Optional<UserDTO> user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build(); // Trả về 404 nếu không tìm thấy
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDetails){
        UserDTO user = userService.updateUser(id, userDetails);
        if (user != null) {
            return ResponseEntity.ok(user); // Trả về sách đã cập nhật
        } else {
            return ResponseEntity.notFound().build(); // Trả về 404 nếu không tìm thấy sách
        }
    }
}
