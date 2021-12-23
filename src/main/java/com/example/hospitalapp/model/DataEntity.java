package com.example.hospitalapp.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface DataEntity
{
    DataEntity create(DataEntity entity);
    DataEntity update(String id);
    List<? extends DataEntity> readAll();
    Optional<? extends DataEntity> read(String id);
    String delete(String id);
    MongoRepository<? extends DataEntity, String> getRepository();
}
