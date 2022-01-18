package com.example.hospitalapp.service;

import com.example.hospitalapp.model.DataEntity;
import com.example.hospitalapp.model.Patient;
import com.example.hospitalapp.repository.PatientRepository;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService extends DataService<Patient, PatientRepository>
{
    private final PatientRepository repository;

    @Autowired
    PatientService(PatientRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public DataEntity create(DataEntity entity) {
        return repository.save((Patient) entity);
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
}
