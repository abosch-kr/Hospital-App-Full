package com.example.hospitalapp.service;

import com.example.hospitalapp.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> getPatients();
    Optional<Patient> getPatient(String id);
    Patient createPatient(Patient doctor);
    Patient updatePatient(String id, Patient doctor);
    String deletePatient(String id);
    void deletePatients();
    Patient treatPatient(String id);
    Patient getPatientByDoctor(String id);
}
