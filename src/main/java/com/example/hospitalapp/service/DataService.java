package com.example.hospitalapp.service;

import com.example.hospitalapp.model.DataEntity;

import java.util.List;
import java.util.Optional;

public interface DataService
{
    DataEntity create(DataEntity entity);
    DataEntity update(String id);
    List<? extends DataEntity> readAll();
    Optional<? extends DataEntity> read(String id);
    String delete(String id);
}
