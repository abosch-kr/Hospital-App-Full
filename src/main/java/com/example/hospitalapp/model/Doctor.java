package com.example.hospitalapp.model;

import com.example.hospitalapp.repository.DoctorRepository;
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

    private @Id Long id;
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

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }

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
        doctor.setName(this.getName());
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

    @Override
    public MongoRepository<? extends DataEntity, String> getRepository()
    {
        return repository;
    }
}
