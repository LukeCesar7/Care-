package com.care.record.service;

import com.care.record.domain.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerService {

    private final SerService repository;

    public SerService(SerService repository) {
        this.repository = repository;
    }
    public Service save(Service service) {
        return repository.save(service);
    }
    public List<Service> findByPatient(Patient patient) {
        return repository.findByPatient(patient);
    }
}
