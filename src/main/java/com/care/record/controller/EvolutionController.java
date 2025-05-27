package com.care.record.controller;

import com.care.record.domain.Evolution;
import com.care.record.domain.Patient;
import com.care.record.service.EvolutionService;
import com.care.record.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evolucoes")
public class EvolutionController {

    private final EvolutionService service;
    private final PatientService patientService;

    public EvolutionController(EvolutionService service, PatientService patientService) {
        this.service = service;
        this.patientService = patientService;
    }

    @PostMapping("/{patientId}")
    public ResponseEntity<Evolution> create(@PathVariable Long patientId, @RequestBody Evolution evolucao) {
        Patient patient = patientService.findById(patientId).orElseThrow();
        evolucao.setPatient(patient);
        return ResponseEntity.ok(service.save(evolucao));
    }

    @GetMapping("/patient/{patientId}")
    public List<Evolution> getByPatient(@PathVariable Long patientId) {
        Patient patient = patientService.findById(patientId).orElseThrow();
        return service.findByPatient(patient);
    }
}
