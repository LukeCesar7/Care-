package com.care.record.service;

import com.care.record.domain.Anamnese;
import com.care.record.domain.Patient;
import com.care.record.repository.AnamneseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnamneseService {
    private final AnamneseRepository anamneseRepository;

    public AnamneseService(AnamneseRepository anamneseRepository) {
        this.anamneseRepository = anamneseRepository;
    }
    public Anamnese save (Anamnese anamnese){
        return anamneseRepository.save(anamnese);
    }
    public List<Anamnese> findByPatient(Patient patient){
        return anamneseRepository.findByPatient(patient);
    }
}
