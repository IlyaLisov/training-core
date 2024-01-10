package com.example.trainingcore.repository;

import com.example.trainingcore.model.Tutor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TutorRepository extends MongoRepository<Tutor, ObjectId> {
}
