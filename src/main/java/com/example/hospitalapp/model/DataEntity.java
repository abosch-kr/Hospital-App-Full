package com.example.hospitalapp.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
public interface DataEntity
{
    void setId(String id);
}
