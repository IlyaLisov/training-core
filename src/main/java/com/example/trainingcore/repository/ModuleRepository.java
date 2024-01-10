package com.example.trainingcore.repository;

import com.example.trainingcore.model.Module;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ModuleRepository extends MongoRepository<Module, ObjectId> {
}
