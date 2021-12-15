package com.example.hospitalapp.repository;

import com.example.hospitalapp.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {}
