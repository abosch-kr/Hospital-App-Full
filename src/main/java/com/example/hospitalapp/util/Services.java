package com.example.hospitalapp.util;

import com.example.hospitalapp.service.DataService;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class Services
{
    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public Map<String, DataService> getServices()
    {
        return applicationContext.getBeansOfType(DataService.class);
    }
}