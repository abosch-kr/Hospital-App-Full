package com.example.hospitalapp.controller;

import com.example.hospitalapp.model.Patient;
import com.example.hospitalapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController
{
    @Autowired
    private PatientService patientService;

    @GetMapping("/")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @GetMapping("/{id}")
    public Optional<Patient> getPatient(@PathVariable String id) {
        return patientService.getPatient(id);
    }

    @PostMapping("/")
    public Patient postPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable String id, @RequestBody Patient updatedPatient) {
        return patientService.updatePatient(id, updatedPatient);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable String id) {
        return patientService.deletePatient(id);
    }

    @DeleteMapping("/")
    public void deletePatients() {
        patientService.deletePatients();
    }

    @PutMapping("/treat/{id}")
    public Patient treatPatient(@PathVariable String id) {
        return patientService.treatPatient(id);
    }

    @GetMapping("/doctor/{doctorId}")
    public Patient getPatientsByDoctor(@PathVariable String doctorId) {
        return patientService.getPatientByDoctor(doctorId);
    }

//    @PutMapping("/{id}/doctor/assign/{doctorId}")
//    public Patient assignDoctor(@PathVariable String id, @PathVariable String doctorId) {
//
//    }
}
