package com.example.hospitalapp.util;

import com.example.hospitalapp.model.DataEntity;
import com.example.hospitalapp.service.DataService;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Services
{
    private static HashMap<String, DataService> models = null;

    private Services()
    {
    }

    public static Map<String, DataService> getServices()
            throws IllegalAccessException, InstantiationException
    {
        if (models == null) {
            models = new HashMap<>();
            Reflections reflections = new Reflections("com.example.hospitalapp.service");
            Set<Class<? extends DataService>> classes = reflections.getSubTypesOf(DataService.class);

            for (Class<? extends DataService> entity : classes) {
                models.put(entity.getSimpleName().toLowerCase(Locale.ROOT), entity.newInstance());
            }
        }
        return models;
    }
}
