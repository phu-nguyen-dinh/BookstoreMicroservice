package com.javaweb.service;

import com.javaweb.model.dto.RegulationDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RegulationService {
    public Optional<RegulationDTO> getRegulationById(Long id);
    public RegulationDTO updateRegulationById(Long id, RegulationDTO newDto);
    public List<RegulationDTO> getAllRegulation();
    public void deleteRegulation(Long id);
    public RegulationDTO addRegulation(RegulationDTO dto);
}
