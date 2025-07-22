package com.javaweb.service.impl;

import com.javaweb.entity.GenreEntity;
import com.javaweb.entity.RegulationEntity;
import com.javaweb.mapper.RegulationMapper;
import com.javaweb.model.dto.RegulationDTO;
import com.javaweb.repository.RegulationRepository;
import com.javaweb.service.RegulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegulationServiceImpl implements RegulationService {

    @Autowired
    RegulationMapper regulationMapper;

    @Autowired
    RegulationRepository regulationRepository;

    @Override
    public Optional<RegulationDTO> getRegulationById(Long id) {
        return regulationRepository.findById(id).map(regulationMapper::toDTO);
    }

    @Override
    public RegulationDTO updateRegulationById(Long id, RegulationDTO newDto) {
        RegulationEntity existingRegulation = regulationRepository.findById(id).orElse(null);
        if(existingRegulation==null){
            System.out.println("Id not found");
            return null;
        }
        existingRegulation.setDateIssued(newDto.getDateIssued());
        existingRegulation.setContent(newDto.getContent());
        RegulationEntity updatedRegulation = regulationRepository.save(existingRegulation);
        return regulationMapper.toDTO(updatedRegulation);
    }

    @Override
    public List<RegulationDTO> getAllRegulation() {
        List<RegulationEntity> regulations = regulationRepository.findAll();
        return regulations.stream().map(regulationMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteRegulation(Long id) {
        RegulationEntity existingRegulation = regulationRepository.findById(id).orElse( null);
        if(existingRegulation == null){
            System.out.println("Regulation not found");
            return;
        }
        regulationRepository.delete(existingRegulation);
    }

    @Override
    public RegulationDTO addRegulation(RegulationDTO dto) {
        RegulationEntity regulation = regulationMapper.toEntity(dto);
        RegulationEntity savedRegulation = regulationRepository.save(regulation);
        return regulationMapper.toDTO(savedRegulation);
    }
}
