package com.example.trainingcore.repository;

import com.example.trainingcore.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

}
