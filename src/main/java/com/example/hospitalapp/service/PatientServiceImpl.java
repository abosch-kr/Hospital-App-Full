package com.example.hospitalapp.service;

import com.example.hospitalapp.model.Patient;
import com.example.hospitalapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository repository;

    @Override
    public List<Patient> getPatients() {
        return repository.findAll();
    }

    @Override
    public Optional<Patient> getPatient(String id) {
        return repository.findById(id);
    }

    @Override
    public Patient createPatient(Patient patient) {
        return repository.save(patient);
    }

    @Override
    public Patient updatePatient(String id, Patient updatedPatient) {
        Patient patient = repository.findById(id).orElse(null);
        assert patient != null;
        patient.setDoctor(updatedPatient.getDoctor());
        patient.setAilments(updatedPatient.getAilments());
        patient.setFirstName(updatedPatient.getFirstName());
        patient.setLastName(updatedPatient.getLastName());
        patient.setSuffix(updatedPatient.getSuffix());
        patient.setMiddleName(updatedPatient.getMiddleName());
        patient.setPriority(updatedPatient.getPriority());

        return repository.save(patient);
    }

    @Override
    public String deletePatient(String id) {
        repository.deleteById(id);
        return id;
    }

    @Override
    public void deletePatients() {
        repository.deleteAll();
    }

    @Override
    public Patient treatPatient(String id) {
        Patient patient = repository.findById(id).orElse(null);
        assert patient != null;
        patient.setTreated(true);
        repository.save(patient);
        return patient;
    }

    @Override
    public Patient getPatientByDoctor(String id) {
        return repository.findPatientByDoctorId(id);
    }
}
