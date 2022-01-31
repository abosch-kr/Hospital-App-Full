package com.example.hospitalapp.repository;

import com.example.hospitalapp.model.Doctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
                .firstName("steve")
                .lastName("doe")
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

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Doctor> doctors = repository.findAll(firstPageWithThreeRecords)
                .getContent();

        long totalElements = repository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = repository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("total elements = " + totalElements);
        System.out.println("total pages = " + totalPages);
        System.out.println("doctors = " + doctors);
    }
}