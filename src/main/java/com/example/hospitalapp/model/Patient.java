package com.example.hospitalapp.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("patient")
@JsonTypeName("patient")
public class Patient implements DataEntity
{
    @Id private String id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private List<String> ailments;
    private int priority;
    private Doctor doctor;
    private boolean treated;

    public Patient()
    {
    }

    public Patient(String firstName, String middleName, String lastName, String suffix,
            List<String> ailments, int priority, Doctor doctor)
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.ailments = ailments;
        this.priority = priority;
        this.doctor = doctor;
        this.treated = false;
    }

    @Id
    public String getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getSuffix()
    {
        return suffix;
    }

    public void setSuffix(String suffix)
    {
        this.suffix = suffix;
    }

    public List<String> getAilments()
    {
        return ailments;
    }

    public void setAilments(List<String> ailments)
    {
        this.ailments = ailments;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    public Doctor getDoctor()
    {
        return doctor;
    }

    public void setDoctor(Doctor doctor)
    {
        this.doctor = doctor;
    }

    public boolean isTreated()
    {
        return treated;
    }

    public void setTreated(boolean treated)
    {
        this.treated = treated;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
