package com.example.hospitalapp.service;

import com.example.hospitalapp.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> getDoctors();
    Optional<Doctor> getDoctor(String id);
    Doctor createDoctor(Doctor doctor);
    Doctor updateDoctor(String id, Doctor doctor);
    String deleteDoctor(String id);
    void deleteDoctors();
    List<Doctor> getDoctorBySpecialty(String specialty);
}
