package com.example.hospitalapp.controller;

import com.example.hospitalapp.model.DataEntity;
import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.model.Patient;
import com.example.hospitalapp.service.DataService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/")
public class BaseController {

    @Autowired
    private Map<String, DataEntity> models;

    @PostMapping("{entityType}")
    public DataEntity post(@RequestBody DataEntity entity, @PathVariable String entityType) {
        return models.get(entityType).create(entity);
    }

    @GetMapping("{entityType}")
    public List<? extends DataEntity> get(@PathVariable String entityType) {
        return models.get(entityType).readAll();
    }

    @GetMapping("{entityType}/{id}")
    public Optional<? extends DataEntity> get(@PathVariable String entityType, @PathVariable String id) {
        return models.get(entityType).read(id);
    }

    @PutMapping("{entityType}/{id}")
    public DataEntity update(@PathVariable String entityType, @PathVariable String id, @RequestBody DataEntity entity) {
        return models.get(entityType).update(id, entity);
    }

    @DeleteMapping("{entityType}/{id}")
    public String delete(@PathVariable String entityType, @PathVariable String id) {
        return models.get(entityType).delete(id);
    }
}
