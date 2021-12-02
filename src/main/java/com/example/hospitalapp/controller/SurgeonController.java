package com.example.hospitalapp.controller;


import com.example.hospitalapp.model.Surgeon;
import com.example.hospitalapp.view.CLIView;
import com.example.hospitalapp.view.View;

public class SurgeonController extends BaseController {
    private final View    view;
    private final Surgeon surgeon;

    public SurgeonController() {
        this.surgeon = new Surgeon("Phil");
        this.view = new CLIView();
    }

    public SurgeonController(View view, Surgeon surgeon) {
        this.surgeon = surgeon;
        this.view = view;
    }


    @Override
    void simulateOperation()
    {
        System.out.println("Simulating Surgeon operation...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    void getDescription()
    {
        view.outputNewLine(surgeon.getClass().getName());
    }
}
