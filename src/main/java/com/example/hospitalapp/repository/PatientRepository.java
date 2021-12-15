package com.example.hospitalapp.repository;

import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PatientRepository extends MongoRepository<Patient, String> {
    Patient findPatientByDoctor(String doctorId);
}
