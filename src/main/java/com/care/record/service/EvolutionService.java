package com.care.record.service;

import com.care.record.domain.Evolution;
import com.care.record.domain.Patient;
import com.care.record.repository.EvolutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvolutionService {
    private final EvolutionRepository repository;

    public EvolutionService(EvolutionRepository repository) {
        this.repository = repository;
    }

    public Evolution save(Evolution evolution) {
        return repository.save(evolution);
    }

    public List<Evolution> findByPatient(Patient patient) {
        return repository.findByPatient(patient);
    }
}
