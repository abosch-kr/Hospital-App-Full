package com.example.hospitalapp.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HospitalEntity
{
    MongoRepository getRepository();
}
