package com.example.hospitalapp.controller;

import com.example.hospitalapp.model.HospitalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @PostMapping("/")
    public HospitalEntity saveHospitalEntity(@RequestBody HospitalEntity entity) {
        MongoRepository repo = entity.getRepository();
        return (HospitalEntity) repo.save(entity);
    }

    @GetMapping("/{id}")
    public HospitalEntity findHospitalEntityById(@PathVariable("id") Long id)
    {
        return null;
    }

    @GetMapping("/")
    public List<HospitalEntity> findAllHospitalEntities()
    {
        return null;
    }
}
