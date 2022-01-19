package com.example.hospitalapp.service;

import com.example.hospitalapp.model.DataEntity;
import com.example.hospitalapp.model.Doctor;
import com.example.hospitalapp.repository.DoctorRepository;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService extends DataService<Doctor, DoctorRepository>
{
    private final DoctorRepository repository;

    @Autowired
    DoctorService(DoctorRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Doctor update(String id, DataEntity updatedDoctor)
    {
        Doctor doctor = repository.findById(id).orElse(null);
        assert doctor != null;
        doctor.setFirstName(((Doctor)updatedDoctor).getFirstName());
        doctor.setLastName(((Doctor)updatedDoctor).getLastName());
        doctor.setSpecialty(((Doctor)updatedDoctor).getSpecialty());

        return repository.save(doctor);
    }
}
