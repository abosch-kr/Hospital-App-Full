package com.example.hospitalapp.controller;


import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.view.CLIView;
import com.example.hospitalapp.view.View;

public class DoctorController extends BaseController {
    private final View   view;
    private       Doctor doctor;

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
