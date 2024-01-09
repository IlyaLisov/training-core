package com.example.trainingcore.repository;

import com.example.trainingcore.model.TextContent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface TextContentRepository
        extends MongoRepository<TextContent, UUID> {
}
