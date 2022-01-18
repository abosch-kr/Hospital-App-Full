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
@Table(name = "tbl_patient")
public class Patient
{
    @Id
    private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    @ElementCollection
    private List<String> ailments;
    @OneToOne
    @JoinColumn(
            name = "doctor_id",
            referencedColumnName = "doctorId"
    )
    private Doctor doctor;
    private boolean treated;

}
