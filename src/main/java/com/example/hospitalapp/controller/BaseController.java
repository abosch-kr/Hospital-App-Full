package com.example.hospitalapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/")
public class BaseController {

//    @Autowired
//    private Map<String, DataService> services;
//
//    @PostMapping("{entityType}")
//    public DataEntity post(@RequestBody DataEntity entity, @PathVariable String entityType) {
//        return services.get(entityType).create(entity);
//    }
//
//    @GetMapping("{entityType}")
//    public List<? extends DataEntity> get(@PathVariable String entityType) {
//        return services.get(entityType).readAll();
//    }
//
//    @GetMapping("{entityType}/{id}")
//    public Optional<? extends DataEntity> get(@PathVariable String entityType, @PathVariable String id) {
//        return services.get(entityType).read(id);
//    }
//
//    @PutMapping("{entityType}/{id}")
//    public DataEntity update(@PathVariable String entityType, @PathVariable String id, @RequestBody DataEntity entity) {
//        return services.get(entityType).update(id, entity);
//    }
//
//    @DeleteMapping("{entityType}/{id}")
//    public String delete(@PathVariable String entityType, @PathVariable String id) {
//        return services.get(entityType).delete(id);
//    }
}
