package com.example.hospitalapp.controller;


import com.example.hospitalapp.model.Nurse;
import com.example.hospitalapp.view.CLIView;
import com.example.hospitalapp.view.View;

public class NurseController extends BaseController {
    private final View  view;
    private       Nurse nurse;

    public NurseController() {
        this.view = new CLIView();
        nurse = new Nurse("Jen");
    }

    public NurseController(View view, Nurse nurse) {
        this.view = view;
        this.nurse = nurse;
    }

    @Override
    void simulateOperation() {
        System.out.println("Simulating Nurse operation...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    void getDescription() {
        view.outputNewLine(nurse.getClass().getName());
    }
}
