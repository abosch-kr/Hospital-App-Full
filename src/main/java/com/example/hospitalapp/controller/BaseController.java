package com.example.hospitalapp.controller;

import com.example.hospitalapp.util.Models;
import com.example.hospitalapp.model.DataEntity;
import com.example.hospitalapp.util.Repositories;
import org.reflections.Reflections;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class BaseController {
    private final Map<String, DataEntity> models;

    public BaseController() throws InstantiationException, IllegalAccessException
    {
        models = Models.getModels();
    }

    @PostMapping("/{entityType}")
    public DataEntity post(@RequestBody DataEntity entity, @PathVariable String entityType) {
        return models.get(entityType).create(entity);
    }

    @GetMapping("/{entityType}")
    public List<? extends DataEntity> get(@PathVariable String entityType) {
        return models.get(entityType).readAll();
    }

    @GetMapping("/{entityType}/{id}")
    public Optional<? extends DataEntity> get(@PathVariable String entityType, @PathVariable String id) {
        return models.get(entityType).getRepository().findById(id);
    }

    @PutMapping("/{entityType}/{id}")
    public DataEntity update(@PathVariable String entityType, @PathVariable String id) {
        return models.get(entityType).update(id);
    }

    @DeleteMapping("/{entityType}/{id}")
    public String delete(@PathVariable String entityType, @PathVariable String id) {
        return models.get(entityType).delete(id);
    }
}
