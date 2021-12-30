package com.example.hospitalapp.controller;

import com.example.hospitalapp.model.DataEntity;
import com.example.hospitalapp.util.Services;
import com.example.hospitalapp.service.DataService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class BaseController {
    private final Map<String, DataService> services;

    public BaseController() throws InstantiationException, IllegalAccessException
    {
        services = Services.getServices();
    }

    @PostMapping("/{serviceType}")
    public DataEntity post(@RequestBody DataEntity entity, @PathVariable String serviceType) {
        return services.get(serviceType).create(entity);
    }

    @GetMapping("/{serviceType}")
    public List<? extends DataEntity> get(@PathVariable String serviceType) {
        return services.get(serviceType).readAll();
    }

    @GetMapping("/{serviceType}/{id}")
    public Optional<? extends DataEntity> get(@PathVariable String serviceType, @PathVariable String id) {
        return services.get(serviceType).read(id);
    }

    @PutMapping("/{serviceType}/{id}")
    public DataEntity update(@PathVariable String serviceType, @PathVariable String id, @RequestBody DataEntity entity) {
        return services.get(serviceType).update(id, entity);
    }

    @DeleteMapping("/{serviceType}/{id}")
    public String delete(@PathVariable String serviceType, @PathVariable String id) {
        return services.get(serviceType).delete(id);
    }
}
