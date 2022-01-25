package com.example.hospitalapp.util;

import com.example.hospitalapp.model.DataEntity;
import com.example.hospitalapp.service.DataService;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.*;

@Configuration
public class Models
{
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public Map<String, DataService> getServices()
    {
        return applicationContext.getBeansOfType(DataService.class);
    }

    @PostConstruct
    public void populateJsonSubtypes() {
//        Reflections reflections = new Reflections("com.example.hospitalapp.model");
//        Set<Class<? extends DataEntity>> classes = reflections.getSubTypesOf(DataEntity.class);
//        for (Class type : classes) {
//            String name = ((JsonTypeName) type.getAnnotation(JsonTypeName.class)).value();
//            objectMapper.registerSubtypes(new NamedType(type, name));
//        }
        for(DataService d : getServices().values()){
            Class c = d.getClass();
            String name = ((JsonTypeName) c.getAnnotation(JsonTypeName.class)).value();
            objectMapper.registerSubtypes(new NamedType(c, name));
        }
    }
}