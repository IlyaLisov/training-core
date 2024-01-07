package com.example.trainingcore.repository;

import com.example.trainingcore.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CourseRepository extends MongoRepository<Course, UUID> {
}
