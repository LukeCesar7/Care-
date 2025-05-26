package com.care.record.repository;

import com.care.record.domain.Evolution;
import com.care.record.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvolutionRepository extends JpaRepository<Evolution, Long> {
    List<Evolution> findByPatient(Patient patient);
}
