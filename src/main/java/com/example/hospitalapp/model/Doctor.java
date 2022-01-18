package com.example.hospitalapp.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "tbl_doctor")
public class Doctor
{
    @Id
    @SequenceGenerator(
            name = "doctor_sequence",
            sequenceName = "doctor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "doctor_sequence"
    )
    private Long doctorId;
    private String firstName;
    private String lastName;
    private String specialty;
}

