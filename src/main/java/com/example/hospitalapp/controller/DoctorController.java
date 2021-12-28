package com.example.hospitalapp.controller;


import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @GetMapping("/")
    public List<Doctor> getDoctors() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getDoctor(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Doctor postDoctor(@RequestBody Doctor doctor) {
        return repository.save(doctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable String id, @RequestBody Doctor updatedDoctor) {
        Doctor doctor = repository.findById(id).orElse(null);
        assert doctor != null;
        doctor.setFirstName(updatedDoctor.getFirstName());
        doctor.setLastName(updatedDoctor.getLastName());
        doctor.setSpecialty(updatedDoctor.getSpecialty());

        return repository.save(doctor);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable String id) {
        repository.deleteById(id);
        return id;
    }

    @DeleteMapping("/")
    public void deleteDoctors() {
        repository.deleteAll();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Doctor> getDoctorsBySpecialty(@RequestParam(value="specialty") String specialty) {
        return repository.findAllBySpecialty(specialty);
    }
}
