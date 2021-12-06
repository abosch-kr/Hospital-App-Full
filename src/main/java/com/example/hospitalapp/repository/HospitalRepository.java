package com.example.hospitalapp.repository;

import com.example.hospitalapp.model.HospitalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HospitalRepository extends MongoRepository<HospitalEntity, String>
{
}
