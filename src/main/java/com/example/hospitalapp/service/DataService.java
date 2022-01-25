package com.example.hospitalapp.service;

import com.example.hospitalapp.model.DataEntity;
import com.example.hospitalapp.model.Doctor;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
public abstract class DataService<T extends DataEntity>
{
    @Autowired
    private MongoRepository<T, String> repository;

    public DataService() { }

    public DataEntity save(T entity) {
        return repository.save(entity);
    }

    public List<T> readAll() {
        return repository.findAll();
    }

    public Optional<T> read(String id) {
        return repository.findById(id);
    }

    public String delete(String id) {
        repository.deleteById(id);
        return id;
    }

    public String deleteAll() {
        try {
            repository.deleteAll();
        } catch (Exception exception) {
            return exception.getMessage();
        }
        return "Deleted all entities";
    }
}
