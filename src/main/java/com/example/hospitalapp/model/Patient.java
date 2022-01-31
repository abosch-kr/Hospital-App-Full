package com.example.hospitalapp.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    public void assignDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
