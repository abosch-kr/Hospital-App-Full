package com.example.hospitalapp.repository;

import com.example.hospitalapp.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PatientRepository extends MongoRepository<Patient, String> {
    Patient findPatientByDoctor(String doctorId);
}
