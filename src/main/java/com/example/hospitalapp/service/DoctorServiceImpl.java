package com.example.hospitalapp.service;

import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepository repository;


    @Override
    public List<Doctor> getDoctors() {
        return repository.findAll();
    }

    @Override
    public Optional<Doctor> getDoctor(String id) {
        return repository.findById(id);
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(String id, Doctor updatedDoctor) {
        Doctor doctor = repository.findById(id).orElse(null);
        assert doctor != null;
        doctor.setFirstName(updatedDoctor.getFirstName());
        doctor.setLastName(updatedDoctor.getLastName());
        doctor.setSpecialty(updatedDoctor.getSpecialty());

        return repository.save(doctor);
    }

    @Override
    public String deleteDoctor(String id) {
        repository.deleteById(id);
        return id;
    }

    @Override
    public void deleteDoctors() {
        repository.deleteAll();
    }

    @Override
    public List<Doctor> getDoctorBySpecialty(String specialty) {
        return repository.findAllBySpecialty(specialty);
    }
}
