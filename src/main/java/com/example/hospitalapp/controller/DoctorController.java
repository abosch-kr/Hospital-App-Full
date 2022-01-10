package com.example.hospitalapp.controller;


import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/")
    public List<Doctor> getDoctors() {
        return doctorService.getDoctors();
    }

    @GetMapping("/{id}")
    public Optional<Doctor> getDoctor(@PathVariable String id) {
        return doctorService.getDoctor(id);
    }

    @PostMapping("/")
    public Doctor postDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable String id, @RequestBody Doctor updatedDoctor) {
        return doctorService.updateDoctor(id, updatedDoctor);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable String id) {
        return doctorService.deleteDoctor(id);
    }

    @DeleteMapping("/")
    public void deleteDoctors() {
        doctorService.deleteDoctors();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Doctor> getDoctorsBySpecialty(@RequestParam(value="specialty") String specialty) {
        return doctorService.getDoctorBySpecialty(specialty);
    }
}
