package com.example.hospitalapp.service;

import java.util.List;
import java.util.Optional;

public interface HelperService<T> {
    List<T> getAll();

    Optional<T> findOne(Long id);

    T create(T entity);

    T update(T entity, Long id);

    void delete(Long id);
}
