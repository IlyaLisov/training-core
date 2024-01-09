package com.example.trainingcore.repository;

import com.example.trainingcore.model.VideoContent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface VideoContentRepository
        extends MongoRepository<VideoContent, UUID> {
}
