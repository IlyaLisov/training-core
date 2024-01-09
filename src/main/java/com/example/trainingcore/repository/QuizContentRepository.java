package com.example.trainingcore.repository;

import com.example.trainingcore.model.QuizContent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface QuizContentRepository
        extends MongoRepository<QuizContent, UUID> {
}
