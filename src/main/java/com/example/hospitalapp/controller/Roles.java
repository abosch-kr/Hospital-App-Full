package com.example.hospitalapp.controller;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public enum Roles {
    EXIT(-1) {
        @Override
        void simulate()
        {
            System.exit(-1);
        }
    }, DOCTOR(1) {
        @Override
        void simulate()
        {
//            BaseController doctorController = new DoctorController();
//            doctorController.simulateOperation();
        }
    }, NURSE(2) {
        @Override
        void simulate()
        {
            BaseController nurseController = new NurseController();
            nurseController.simulateOperation();

        }
    }, SURGEON(3) {
        @Override
        void simulate()
        {
            BaseController surgeonController = new SurgeonController();
            surgeonController.simulateOperation();
        }
    };

    private final int value;
    private static final Map<Integer, Roles> map = new HashMap<>();
    Roles(final int value) {
        this.value = value;
    }

    static {
        for (Roles role : Roles.values()) {
            map.put(role.value, role);
        }
    }

    abstract void simulate();

    private static Roles valueOf(int value) {
        return map.get(value);
    }

    public static void printRoles() {
        for (Roles role: map.values()) {
            System.out.println(role.value + " " + map.get(role.value));
        }
    }

    public static void simulate(int value) {
        try {
            Roles.valueOf(value).simulate();
        } catch (NullPointerException ex) {
            System.out.println("Invalid Role");
        } catch (InputMismatchException ex) {
            System.out.println("Enter a Number");
        }
    }
}