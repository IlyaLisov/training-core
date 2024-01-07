package com.example.trainingcore.repository;

import com.example.trainingcore.model.Progress;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ProgressRepository extends MongoRepository<Progress, UUID> {
}
