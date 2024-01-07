package com.example.trainingcore.repository;

import com.example.trainingcore.model.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface TutorRepository extends MongoRepository<Tutor, UUID> {
}
