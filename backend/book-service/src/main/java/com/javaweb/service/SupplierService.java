package com.javaweb.service;

import com.javaweb.model.dto.SupplierDTO;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    public List<SupplierDTO> getAllSuppliers();
    public Optional<SupplierDTO> getSupplierById(Long id);
    public void deleteSupplier(Long id);
    public SupplierDTO addSupplier(SupplierDTO supplier);
    public SupplierDTO updateSupplier(Long id, SupplierDTO supplier);
}
