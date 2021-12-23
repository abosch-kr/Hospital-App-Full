package com.example.hospitalapp.util;

import com.example.hospitalapp.model.DataEntity;
import com.example.hospitalapp.model.Patient;
import org.reflections.Reflections;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Repositories
{
    private static HashMap<String, MongoRepository<? extends DataEntity, String>> repositories;

    private Repositories() throws IllegalAccessException, InstantiationException
    {
        repositories = new HashMap<>();
        Reflections reflections = new Reflections("com.example.hospitalapp.model");
        Set<Class<? extends DataEntity>> classes = reflections.getSubTypesOf(DataEntity.class);

        for (Class<? extends DataEntity> entity : classes) {
            repositories.put(entity.getName().toLowerCase(Locale.ROOT), entity.newInstance().getRepository());
        }
    }

    public static Map<String, MongoRepository<? extends DataEntity, String>> getRepositories() {
        return repositories;
    }
}
