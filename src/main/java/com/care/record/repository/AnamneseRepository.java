package com.care.record.repository;

import com.care.record.domain.Anamnese;
import com.care.record.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnamneseRepository extends JpaRepository<Anamnese, Long> {
    List<Anamnese> findByPatient(Patient patient);
}
