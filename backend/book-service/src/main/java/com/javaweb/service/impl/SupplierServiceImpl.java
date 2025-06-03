package com.javaweb.service.impl;

import com.javaweb.entity.SupplierEntity;
import com.javaweb.mapper.SupplierMapper;
import com.javaweb.model.dto.SupplierDTO;
import com.javaweb.repository.SupplierRepository;
import com.javaweb.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    SupplierMapper supplierMapper;

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        List<SupplierEntity> entities = supplierRepository.findAll();
        return entities.stream()
                .map(supplierMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SupplierDTO> getSupplierById(Long id) {
        return supplierRepository.findById(id)
                .map(supplierMapper::toDTO);
    }

    @Override
    public void deleteSupplier(Long id) {
        SupplierEntity existingSupplier = supplierRepository.findById(id).orElse(null);
        if (existingSupplier == null) {
            System.out.println("Supplier not found.");
            return;
        }

        supplierRepository.delete(existingSupplier);
        System.out.println("Supplier deleted successfully.");
    }

    @Override
    public SupplierDTO addSupplier(SupplierDTO supplier) {
        SupplierEntity existingSupplier = supplierRepository.findBySupplierName(supplier.getSupplierName());
        if (existingSupplier != null) {
            System.out.println("Supplier with this name already exists.");
            return null;
        }
        SupplierEntity supplierEntity =  supplierMapper.toEntity(supplier);
        SupplierEntity savedSupplier = supplierRepository.save(supplierEntity);
        return supplierMapper.toDTO(savedSupplier);
    }

    @Override
    public SupplierDTO updateSupplier(Long id, SupplierDTO supplier) {
        SupplierEntity existingSupplier = supplierRepository.findById(id).orElse(null);
        if (existingSupplier == null) {
            System.out.println("Genre not found.");
            return null;
        }
        existingSupplier.setSupplierName(supplier.getSupplierName());
        SupplierEntity updatedSupplier = supplierRepository.save(existingSupplier);
        return supplierMapper.toDTO(updatedSupplier);
    }
}
