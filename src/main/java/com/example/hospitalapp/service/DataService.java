package com.example.hospitalapp.service;

import com.example.hospitalapp.model.DataEntity;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
public abstract class DataService<T, S extends MongoRepository<? extends DataEntity, String>>
{
    private final S repository;

    DataService(S repository) {
        this.repository = repository;
    }

    public abstract DataEntity create(DataEntity entity);

    public abstract DataEntity update(String id, DataEntity entity);

    public List<T> readAll() {
        return (List<T>) repository.findAll();
    }

    public Optional<T> read(String id) {
        return (Optional<T>) repository.findById(id);
    }

    public String delete(String id) {
        repository.deleteById(id);
        return id;
    }
}
