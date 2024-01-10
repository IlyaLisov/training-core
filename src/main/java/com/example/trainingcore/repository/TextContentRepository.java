package com.example.trainingcore.repository;

import com.example.trainingcore.model.TextContent;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TextContentRepository
        extends MongoRepository<TextContent, ObjectId> {
}
