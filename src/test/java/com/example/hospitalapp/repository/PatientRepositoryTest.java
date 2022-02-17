package com.example.hospitalapp.repository;

import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientRepositoryTest {

    @Autowired PatientRepository repository;

    @Test
    public void savePatient() {
        Doctor doctor = Doctor.builder()
                .firstName("tom")
                .lastName("smith")
                .specialty("dentist")
                .build();

//        Patient patient = Patient.builder()
//                .firstName("anthony")
//                .middleName("jose")
//                .lastName("bosch")
//                .suffix("jr")
//                .ailments(List.of("headache", "stomachache", "rash"))
//                .treated(false)
//                .doctor(doctor)
//                .build();

//        repository.save(patient);
    }
}