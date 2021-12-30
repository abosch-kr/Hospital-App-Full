package com.example.hospitalapp.service;

import com.example.hospitalapp.model.DataEntity;
import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public class DoctorService implements DataService
{
    @Autowired
    private DoctorRepository repository;

    @Override
    public Doctor create(DataEntity doctor)
    {
        return repository.save((Doctor) doctor);
    }

    @Override
    public Doctor update(String id)
    {
        Doctor doctor = repository.findById(id).orElse(null);
        assert doctor != null;
        return doctor;
    }

    @Override
    public List<Doctor> readAll()
    {
        return repository.findAll();
    }

    @Override
    public Optional<Doctor> read(String id)
    {
        return repository.findById(id);
    }

    @Override
    public String delete(String id)
    {
        repository.deleteById(id);
        return id;
    }
}
