package com.example.hospitalapp.controller;

import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.model.Patient;
import com.example.hospitalapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController
{
    @Autowired
    private PatientRepository repository;

    @GetMapping("/")
    public List<Patient> getPatients() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Patient postPatient(@RequestBody Patient patient) {
        return repository.save(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable String id, @RequestBody Patient updatedPatient) {
        Patient patient = repository.findById(id).orElse(null);
        assert patient != null;
        patient.setDoctor(updatedPatient.getDoctor());
        patient.setAilments(updatedPatient.getAilments());
        patient.setFirstName(updatedPatient.getFirstName());
        patient.setLastName(updatedPatient.getLastName());
        patient.setSuffix(updatedPatient.getSuffix());
        patient.setMiddleName(updatedPatient.getMiddleName());
        patient.setPriority(updatedPatient.getPriority());

        return repository.save(patient);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable String id) {
        repository.deleteById(id);
        return id;
    }

    @DeleteMapping("/")
    public void deletePatients() {
        repository.deleteAll();
    }

    @PutMapping("/treat/{id}")
    public Patient treatPatient(@PathVariable String id) {
        Patient patient = repository.findById(id).orElse(null);
        assert patient != null;
        patient.setTreated(true);
        repository.save(patient);
        return patient;
    }

    @GetMapping("/doctor/{doctorId}")
    public Patient getPatientsByDoctor(@PathVariable String doctorId) {
        return repository.findPatientByDoctorId(doctorId);
    }

//    @PutMapping("/{id}/doctor/assign/{doctorId}")
//    public Patient assignDoctor(@PathVariable String id, @PathVariable String doctorId) {
//
//    }
}
