package com.example.hospitalapp.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;
import java.util.Optional;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
public interface DataEntity
{
    DataEntity create(DataEntity entity);
    DataEntity update(String id, DataEntity entity);
    List<? extends DataEntity> readAll();
    Optional<? extends DataEntity> read(String id);
    String delete(String id);
}
