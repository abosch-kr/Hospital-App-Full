package com.example.hospitalapp.model;

import com.example.hospitalapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

public class Doctor implements HospitalEntity
{
    @Id
    private Long id;

    @Autowired
    private DoctorRepository repository;

    private String name;

    public Doctor(String name)
    {
        this.name = name;
    }

    public Doctor() { }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    @Override
    public DoctorRepository getRepository()
    {
        return repository;
    }
}
