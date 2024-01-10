package com.example.trainingcore.repository;

import com.example.trainingcore.model.Progress;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProgressRepository
        extends MongoRepository<Progress, ObjectId> {
}
