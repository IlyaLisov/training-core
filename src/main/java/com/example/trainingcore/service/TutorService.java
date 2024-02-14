package com.example.trainingcore.service;

import com.example.trainingcore.model.Tutor;

public interface TutorService extends CrudService<Tutor> {

    Tutor getByUsername(String username);

    boolean existsByUsername(String username);

}
