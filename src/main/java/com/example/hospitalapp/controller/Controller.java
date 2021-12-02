package com.example.hospitalapp.controller;


import com.example.hospitalapp.view.CLIView;
import com.example.hospitalapp.view.View;

public class Controller {
    protected View view;

    public Controller() {
        this.view = new CLIView();
    }

    public Controller(View view) {
        this.view = view;
    }

    private int getRoleNumber() {
        view.output("Enter role number: ");
        return view.intInput();
    }

    public void simulateOperation() {
        outputRoles();
        int role = getRoleNumber();

        while (true) {
            Roles.simulate(role);
            role = getRoleNumber();
        }
    }

    private void outputRoles() {
        Roles.printRoles();
    }
}
