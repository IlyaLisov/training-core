package com.example.trainingcore.repository;

import com.example.trainingcore.model.CourseInfo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseInfoRepository
        extends MongoRepository<CourseInfo, ObjectId> {
}
