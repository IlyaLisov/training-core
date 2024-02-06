package com.example.trainingcore.service;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudService<C> {

    C getById(ObjectId id);

    List<C> getAll(Pageable page);

    C create(C entity);

    C update(C entity);

    boolean existsById(ObjectId id);

    void delete(ObjectId id);

}
