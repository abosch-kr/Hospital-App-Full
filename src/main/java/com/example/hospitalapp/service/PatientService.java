package com.example.hospitalapp.service;

import com.example.hospitalapp.model.DataEntity;
import com.example.hospitalapp.model.Patient;
import com.example.hospitalapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements DataService
{
    @Autowired
    private PatientRepository repository;

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
