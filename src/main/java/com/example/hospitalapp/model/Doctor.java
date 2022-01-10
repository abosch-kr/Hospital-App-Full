package com.example.hospitalapp.model;

import com.example.hospitalapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("doctor")
public class Doctor implements DataEntity
{
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String specialty;

    @Autowired
    private DoctorRepository repository;

    public Doctor(String firstName, String lastName, String specialty)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    public Doctor() {

    }

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

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getSpecialty()
    {
        return specialty;
    }

    public void setSpecialty(String specialty)
    {
        this.specialty = specialty;
    }

    @Override
    public Doctor create(DataEntity doctor)
    {
        return repository.save((Doctor) doctor);
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

    @Override
    public List<Doctor> readAll()
    {
        return repository.findAll();
    }

    @Override
    public Optional<Doctor> read(String id)
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
