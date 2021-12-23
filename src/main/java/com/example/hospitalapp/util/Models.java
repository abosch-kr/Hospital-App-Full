package com.example.hospitalapp.util;

import com.example.hospitalapp.model.DataEntity;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Models
{
    private static HashMap<String, DataEntity> models;

    private Models() throws IllegalAccessException, InstantiationException
    {
        models = new HashMap<>();
        Reflections reflections = new Reflections("com.example.hospitalapp.model");
        Set<Class<? extends DataEntity>> classes = reflections.getSubTypesOf(DataEntity.class);

        for (Class<? extends DataEntity> entity : classes) {
            models.put(entity.getName().toLowerCase(Locale.ROOT), entity.newInstance());
        }
    }

    public static Map<String, DataEntity> getModels() {
        return models;
    }
}
