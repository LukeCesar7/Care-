package com.care.record.controller;

import com.care.record.domain.Anamnese;
import com.care.record.domain.Patient;
import com.care.record.service.AnamneseService;
import com.care.record.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/anamneses")
public class AnamneseController {

    private final AnamneseService service;
    private final PatientService patientService;

    public AnamneseController(AnamneseService service, PatientService patientService) {
        this.service = service;
        this.patientService = patientService;
    }

    @PostMapping("/{patientId}")
    public ResponseEntity<Anamnese> create(@PathVariable Long patientId, @RequestBody Anamnese anamnese) {
        Patient patient = patientService.findById(patientId).orElseThrow();
        anamnese.setPatient(patient);
        return ResponseEntity.ok(service.save(anamnese));
    }

    @GetMapping("/patient/{patientId}")
    public List<Anamnese> getByPatient(@PathVariable Long patientId) {
        Patient patient = patientService.findById(patientId).orElseThrow();
        return service.findByPatient(patient);
    }
}
