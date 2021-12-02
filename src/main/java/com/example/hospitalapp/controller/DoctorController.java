package com.example.hospitalapp.controller;


import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.repository.DoctorRepository;
import com.example.hospitalapp.view.CLIView;
import com.example.hospitalapp.view.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController extends BaseController {
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

    @PutMapping("/")
    public Doctor putDoctor(@RequestBody Doctor updatedDoctor) {
        Doctor doctor = repository.findById(updatedDoctor.getId()).orElse(null);
        assert doctor != null;
        doctor.setName(updatedDoctor.getName());
        return doctor;
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable String id) {
        repository.deleteById(id);
        return id;
    }

    private final View   view;
    private final Doctor doctor;



    public DoctorController()
    {
        this.view = new CLIView();
        this.doctor = new Doctor("Tom");
    }

    public DoctorController(View view, Doctor doctor) {
        this.view = view;
        this.doctor = doctor;
    }

    @Override
    void simulateOperation() {
        System.out.println("Simulating Doctor operation...");
    }

    @Override
    void getDescription() {
        view.outputNewLine(doctor.getClass().getName());
    }
}
