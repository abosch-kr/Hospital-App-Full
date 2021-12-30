package com.example.hospitalapp.model;

import com.example.hospitalapp.repository.DoctorRepository;
import com.example.hospitalapp.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Doctor implements DataEntity
{
    @Autowired
    private DoctorRepository repository;

    private @Id String id;
    private String name;

    public Doctor(String name)
    {
        this.name = name;
    }

    public Doctor() {

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }
}
