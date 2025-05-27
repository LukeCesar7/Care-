package com.care.record.controller;
import com.care.record.domain.Patient;
import com.care.record.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Patient> Create(@RequestBody Patient patient) {
        return ResponseEntity.ok(service.save(patient));
    }
    @GetMapping
    public List<Patient> getAll() {
        return service.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
