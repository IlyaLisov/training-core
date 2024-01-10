package com.example.trainingcore.repository;

import com.example.trainingcore.model.VideoContent;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoContentRepository
        extends MongoRepository<VideoContent, ObjectId> {
}
