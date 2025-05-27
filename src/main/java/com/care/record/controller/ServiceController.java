package com.care.record.controller;

import com.care.record.domain.Patient;
import com.care.record.domain.Service;
import com.care.record.service.PatientService;
import com.care.record.service.SerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final SerService service;
    private final PatientService patientService;

    public ServiceController(SerService service, PatientService patientService) {
        this.service = service;
        this.patientService = patientService;
    }

    @PostMapping("/{patientId}")
    public ResponseEntity<Service> create(@PathVariable Long patientId, @RequestBody Service service) {
        Patient patient = patientService.findById(patientId).orElseThrow();
        service.setPatient(patient);
        return ResponseEntity.ok(service.save(service));
    }

    @GetMapping("/patient/{patientId}")
    public List<org.springframework.stereotype.Service> getByPatient(@PathVariable Long patientId) {
        Patient patient = patientService.findById(patientId).orElseThrow();
        return service.findByPatient(patient);
    }
}

