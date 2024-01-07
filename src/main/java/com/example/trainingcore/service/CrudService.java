package com.example.trainingcore.service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CrudService<C> {

    C getById(UUID id);

    List<C> getAll(Pageable page);

    C create(C entity);

    C update(C entity);

    void delete(UUID id);

}
