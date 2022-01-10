package com.example.hospitalapp.model;

import com.example.hospitalapp.repository.PatientRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component("patient")
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


    @Autowired
    private PatientRepository repository;

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
    public Patient create(DataEntity patient)
    {
        return repository.save((Patient) patient);
    }

    @Override
    public Patient update(String id, DataEntity updatedPatient)
    {
        Patient patient = repository.findById(id).orElse(null);
        assert patient != null;
        patient.setDoctor(((Patient)updatedPatient).getDoctor());
        patient.setAilments(((Patient)updatedPatient).getAilments());
        patient.setFirstName(((Patient)updatedPatient).getFirstName());
        patient.setLastName(((Patient)updatedPatient).getLastName());
        patient.setSuffix(((Patient)updatedPatient).getSuffix());
        patient.setMiddleName(((Patient)updatedPatient).getMiddleName());
        patient.setPriority(((Patient)updatedPatient).getPriority());

        return repository.save(patient);
    }

    @Override
    public List<Patient> readAll()
    {
        return repository.findAll();
    }

    @Override
    public Optional<Patient> read(String id)
    {
        return repository.findById(id);
    }

    @Override
    public String delete(String id)
    {
        repository.deleteById(id);
        return id;
    }
}
