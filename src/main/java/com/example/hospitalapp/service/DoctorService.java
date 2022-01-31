package com.example.hospitalapp.service;

import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService implements HelperService<Doctor>{

    @Autowired
    private DoctorRepository repository;

    @Override
    public List<Doctor> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Doctor> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public Doctor create(Doctor entity) {
        return repository.save(entity);
    }

    @Override
    public Doctor update(Doctor entity, Long id) {
        Doctor existingDoctor = repository.findById(id).orElse(null);
        assert existingDoctor != null;
        existingDoctor.setFirstName(entity.getFirstName());
        existingDoctor.setLastName(entity.getLastName());
        existingDoctor.setSpecialty(entity.getSpecialty());

        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
