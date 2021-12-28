package com.example.hospitalapp.repository;

import com.example.hospitalapp.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
    List<Doctor> findAllBySpecialty(String specialty);
}
