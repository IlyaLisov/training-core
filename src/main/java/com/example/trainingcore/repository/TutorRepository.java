package com.example.trainingcore.repository;

import com.example.trainingcore.model.Tutor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TutorRepository extends MongoRepository<Tutor, ObjectId> {

    Optional<Tutor> findByUsername(String username);

    boolean existsByUsername(String username);

}
