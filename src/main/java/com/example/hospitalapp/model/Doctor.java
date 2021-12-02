package com.example.hospitalapp.model;

import org.springframework.data.annotation.Id;

public class Doctor
{
    @Id
    private String id;

    private String name;

    public Doctor(String name)
    {
        this.name = name;
    }

    public Doctor() { }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }
}
