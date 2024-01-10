package com.example.trainingcore.repository;

import com.example.trainingcore.model.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, ObjectId> {
}
