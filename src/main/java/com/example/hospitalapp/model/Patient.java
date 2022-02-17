package com.example.hospitalapp.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@ToString
@Table(name = "PATIENT")
public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private boolean treated;

    @ElementCollection
    private List<String> ailments;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    public Patient() {
    }

    public Patient(String firstName, String middleName, String lastName, String suffix, List<String> ailments) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.treated = false;
        this.ailments = ailments;
        this.doctor = null;
    }

    public void assignDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
