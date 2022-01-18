package com.example.hospitalapp.repository;

import com.example.hospitalapp.model.DataEntity;
import com.example.hospitalapp.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> { }
