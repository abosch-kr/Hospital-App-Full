package com.example.hospitalapp.controller;

import com.example.hospitalapp.model.HospitalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface AdminController
{
    @GetMapping("/")
    List<HospitalEntity> get();

    @GetMapping("/{id}")
    HospitalEntity get(@PathVariable String id);

    @PostMapping("/")
    HospitalEntity post(@RequestBody HospitalEntity entity);

    @PutMapping("/")
    HospitalEntity update(@RequestBody HospitalEntity updatedEntity);

    @DeleteMapping("/{id}")
    String delete(@PathVariable String id);
}
