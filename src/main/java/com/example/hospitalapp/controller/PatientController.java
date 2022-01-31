package com.example.hospitalapp.controller;

import com.example.hospitalapp.model.Patient;
import com.example.hospitalapp.repository.DoctorRepository;
import com.example.hospitalapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/")
    public Patient post(@RequestBody Patient entity) {
        return patientService.create(entity);
    }

    @GetMapping("/")
    public List<Patient> get() {
        return patientService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Patient> get(@PathVariable Long id) {
        return patientService.findOne(id);
    }

    @PutMapping("/{id}")
    public Patient update(@RequestBody Patient entity, @PathVariable Long id) {
        return patientService.update(entity, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        patientService.delete(id);
    }

    @PutMapping("/{patientId}/doctor/{doctorId}")
    public Patient assignDoctorToPatient(@PathVariable Long patientId, @PathVariable Long doctorId) {
        return patientService.assignDoctorToPatient(patientId, doctorId);
    }
}