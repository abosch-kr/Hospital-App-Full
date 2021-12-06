package com.example.hospitalapp.controller;

import com.example.hospitalapp.model.HospitalEntity;
import com.example.hospitalapp.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class AdminController implements HospitalController
{
    @Autowired
    private HospitalRepository repository;

    @Override
    public List<HospitalEntity> get()
    {
        return repository.findAll();
    }

    @Override
    public HospitalEntity get(String id)
    {
        return repository.findById(id).orElse(null);
    }

    @Override
    public HospitalEntity post(HospitalEntity entity)
    {
        return repository.save(entity);
    }

    @Override
    public HospitalEntity update(HospitalEntity updatedEntity) {
        HospitalEntity entity = repository.findById(updatedEntity.getId()).orElse(null);
        assert entity != null;
        entity = updatedEntity;
        return entity;
    }


    @Override
    public String delete(String id)
    {
        repository.deleteById(id);
        return id;
    }
}
