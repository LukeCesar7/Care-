package com.care.record.service;

import com.care.record.domain.Patient;
import com.care.record.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public Patient save(Patient patient) {
        return repository.save(patient);
    }

    public List<Patient> findAll() {
        return repository.findAll();
    }

    public Optional<Patient> findById(Long id) {
        return repository.findById(id);
    }
    public Optional<Patient> findByRa(String ra) {
        return repository.findByRa(ra);
    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
