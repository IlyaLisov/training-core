package com.example.trainingcore.repository;

import com.example.trainingcore.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface StudentRepository extends MongoRepository<Student, UUID> {
}
