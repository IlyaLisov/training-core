package com.example.trainingcore.repository;

import com.example.trainingcore.model.Course;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, ObjectId> {
}
