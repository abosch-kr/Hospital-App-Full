package com.example.hospitalapp.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
public interface DataEntity
{
    void setId(String id);
}
