package com.example.hospitalapp.repository;

import com.example.hospitalapp.model.Doctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
// use @DataJpaTest to not make changes to the DB
class DoctorRepositoryTest {

    @Autowired
    private DoctorRepository repository;

    @Test
    public void saveDoctor() {
        Doctor doctor = Doctor.builder()
                .firstName("tom")
                .lastName("bosch")
                .specialty("surgeon")
                .build();

        repository.save(doctor);
    }

    @Test
    public void printAllDoctors() {
        List<Doctor> doctorList = repository.findAll();

        doctorList.forEach(doctor -> {
            System.out.println(doctor.toString());
        });
    }
}