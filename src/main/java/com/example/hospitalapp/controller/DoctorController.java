package com.example.hospitalapp.controller;


import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;

    @GetMapping("/")
    public List<Doctor> get() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Doctor get(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Doctor post(@RequestBody Doctor doctor) {
        return repository.save(doctor);
    }

    @PutMapping("/")
    public Doctor update(@RequestBody Doctor updatedDoctor) {
        Doctor doctor = repository.findById(updatedDoctor.getId()).orElse(null);
        assert doctor != null;
        doctor.setName(updatedDoctor.getName());
        return doctor;
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        repository.deleteById(id);
        return id;
    }
}
