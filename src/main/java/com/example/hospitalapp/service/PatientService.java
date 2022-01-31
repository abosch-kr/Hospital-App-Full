package com.example.hospitalapp.service;

import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.model.Patient;
import com.example.hospitalapp.repository.DoctorRepository;
import com.example.hospitalapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements HelperService<Patient> {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired DoctorRepository doctorRepository;

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findOne(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient create(Patient entity) {
        return patientRepository.save(entity);
    }

    @Override
    public Patient update(Patient entity, Long id) {
        Patient existingPatient = patientRepository.findById(id).orElse(null);
        assert existingPatient != null;
        existingPatient.setFirstName(entity.getFirstName());
        existingPatient.setLastName(entity.getLastName());
        existingPatient.setMiddleName(entity.getMiddleName());
        existingPatient.setSuffix(entity.getSuffix());
        existingPatient.setDoctor(entity.getDoctor());
        existingPatient.setAilments(entity.getAilments());
        existingPatient.setTreated(entity.isTreated());

        return patientRepository.save(existingPatient);
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient assignDoctorToPatient(Long patientId, Long doctorId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);

        assert patient != null;
        patient.assignDoctor(doctor);

        return patientRepository.save(patient);
    }
}
