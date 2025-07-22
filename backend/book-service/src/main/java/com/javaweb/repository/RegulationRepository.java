package com.javaweb.repository;

import com.javaweb.entity.RegulationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegulationRepository extends JpaRepository<RegulationEntity, Long> {
    Optional<RegulationEntity> findById(Long id);
}
