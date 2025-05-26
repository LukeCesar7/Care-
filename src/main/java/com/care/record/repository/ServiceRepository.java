package com.care.record.repository;

import com.care.record.domain.Patient;
import com.care.record.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findByPatient(Patient patient);
}
