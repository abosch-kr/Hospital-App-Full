package com.example.hospitalapp.util;

import com.example.hospitalapp.model.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class Models
{
    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public Map<String, DataEntity> getServices()
    {
        return applicationContext.getBeansOfType(DataEntity.class);
    }
}