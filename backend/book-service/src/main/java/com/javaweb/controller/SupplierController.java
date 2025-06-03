package com.javaweb.controller;

import com.javaweb.model.dto.SupplierDTO;
import com.javaweb.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    // Endpoint lấy toàn bộ thể Nhà cung cấp
    @GetMapping("/all")
    public ResponseEntity<List<SupplierDTO>> getAllSupplier() {
        List<SupplierDTO> supplier = supplierService.getAllSuppliers();
        if (supplier.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 nếu không có Nhà cung cấp nào
        } else {
            return ResponseEntity.ok(supplier); // Trả về danh sách Nhà cung cấp
        }
    }

    // Endpoint lấy Nhà cung cấp theo id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<SupplierDTO>> getSupplierById(@PathVariable Long id) {
        Optional<SupplierDTO> supplier = supplierService.getSupplierById(id);
        if (supplier != null) {
            return ResponseEntity.ok(supplier); // Trả về Nhà cung cấp nếu tìm thấy
        } else {
            return ResponseEntity.notFound().build(); // Trả về 404 nếu không tìm thấy Nhà cung cấp
        }
    }
    // Endpoint thêm Nhà cung cấp mới
    @PostMapping("/add")
    public ResponseEntity<SupplierDTO> addSupplier(@RequestBody SupplierDTO supplier) {
        SupplierDTO existingSupplier = supplierService.addSupplier(supplier);
        if (existingSupplier != null) {
            return ResponseEntity.status(201).body(existingSupplier); // Trả về 201 nếu thêm thành công
        } else {
            return ResponseEntity.status(400).body(null); // Trả về 400 nếu có lỗi
        }
    }
    // Endpoint cập nhật thông tin Nhà cung cấp
    @PutMapping("/update/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable Long id, @RequestBody SupplierDTO supplierDetails) {
        SupplierDTO supplier = supplierService.updateSupplier(id, supplierDetails);
        if (supplier != null) {
            return ResponseEntity.ok(supplier); // Trả về Nhà cung cấp đã cập nhật
        } else {
            return ResponseEntity.notFound().build(); // Trả về 404 nếu không tìm thấy Nhà cung cấp
        }
    }
    // Endpoint xóa Nhà cung cấp
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id); // Gọi phương thức xóa Nhà cung cấp
        return ResponseEntity.noContent().build(); // Trả về 204 nếu xóa thành công
    }
}
