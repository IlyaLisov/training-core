package com.example.trainingcore.repository;

import com.example.trainingcore.model.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, ObjectId> {

    Optional<Student> findByUsername(String username);

    boolean existsByUsername(String username);

}
