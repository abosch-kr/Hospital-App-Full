package com.example.hospitalapp.controller;


import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/")
    public Doctor post(@RequestBody Doctor entity) {
        return doctorService.create(entity);
    }

    @GetMapping("/")
    public List<Doctor> get() {
        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> get(@PathVariable Long id) {
        return doctorService.findOne(id);
    }

    @PutMapping("/{id}")
    public Doctor update(@RequestBody Doctor entity, @PathVariable Long id) {
        return doctorService.update(entity, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        doctorService.delete(id);
    }
}
