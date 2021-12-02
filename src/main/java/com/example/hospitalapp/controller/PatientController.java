package com.example.hospitalapp.controller;

import com.example.hospitalapp.model.Patient;
import com.example.hospitalapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController
{
    @Autowired
    private PatientRepository repository;

    @GetMapping("/")
    public List<Patient> getPatients() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Patient getDoctor(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Patient postDoctor(@RequestBody Patient patient) {
        return repository.save(patient);
    }

    @PutMapping("/")
    public Patient putDoctor(@RequestBody Patient updatedPatient) {
        Patient patient = repository.findById(updatedPatient.getId()).orElse(null);
        assert patient != null;
        patient.setDoctor(updatedPatient.getDoctor());
        patient.setAilments(updatedPatient.getAilments());
        patient.setFirstName(updatedPatient.getFirstName());
        patient.setLastName(updatedPatient.getLastName());
        patient.setSuffix(updatedPatient.getSuffix());
        patient.setMiddleName(updatedPatient.getMiddleName());
        patient.setPriority(updatedPatient.getPriority());
        return patient;
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable String id) {
        repository.deleteById(id);
        return id;
    }
}
