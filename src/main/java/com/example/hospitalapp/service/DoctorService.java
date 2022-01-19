package com.example.hospitalapp.service;

import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends DataService<Doctor, DoctorRepository>
{
    private final DoctorRepository repository;

    @Autowired
    DoctorService(DoctorRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
