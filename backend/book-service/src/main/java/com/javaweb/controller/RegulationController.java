package com.javaweb.controller;

import com.javaweb.entity.RegulationEntity;
import com.javaweb.model.dto.RegulationDTO;
import com.javaweb.service.RegulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/regulation")
public class RegulationController {
    @Autowired
    private RegulationService regulationService;

    // endpoint lấy toàn bộ regulation
    @GetMapping("/all")
    public ResponseEntity<List<RegulationDTO>> getAllRegulation(){
        List<RegulationDTO> regulations = regulationService.getAllRegulation();

        if (regulations.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 nếu không có Nhà cung cấp nào
        } else {
            return ResponseEntity.ok(regulations); // Trả về danh sách Nhà cung cấp
        }
    }

    // endpoint lấy regulation bằng id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<RegulationDTO>> getRegulationById(@PathVariable Long id){
         Optional<RegulationDTO> regulation = regulationService.getRegulationById(id);

        if (regulation.isEmpty()) {
            return ResponseEntity.noContent().build(); // Trả về 204 nếu không có Nhà cung cấp nào
        } else {
            return ResponseEntity.ok(regulation); // Trả về danh sách Nhà cung cấp
        }
    }

    //endpoint delete regulation
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRegulation(@PathVariable Long id){
        regulationService.deleteRegulation(id);
        return ResponseEntity.noContent().build();
    }

    //endpoint update regulation
    @PutMapping("/update/{id}")
    public ResponseEntity<RegulationDTO> updateRegulation(@PathVariable Long id, @RequestBody RegulationDTO regulationDetails){
        RegulationDTO regulation = regulationService.updateRegulationById(id, regulationDetails);
        if(regulation!=null){
            return ResponseEntity.ok(regulation);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //endpoint adding regulation
    @PostMapping("/add")
    public ResponseEntity<RegulationDTO> addRegulation(@RequestBody RegulationDTO dto){
        RegulationDTO regulation = regulationService.addRegulation(dto);
        if (regulation != null) {
            return ResponseEntity.status(201).body(regulation); // Trả về 201 nếu thêm thành công
        } else {
            return ResponseEntity.status(400).body(null); // Trả về 400 nếu có lỗi
        }
    }
}
