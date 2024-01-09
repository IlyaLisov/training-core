package com.example.trainingcore.repository;

import com.example.trainingcore.model.CourseInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CourseInfoRepository
        extends MongoRepository<CourseInfo, UUID> {
}
