package com.example.trainingcore.service;

import com.example.trainingcore.model.Student;

public interface StudentService extends CrudService<Student> {

    Student getByUsername(String username);

    boolean existsByUsername(String username);

}
