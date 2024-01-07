package com.example.trainingcore.repository;

import com.example.trainingcore.model.Module;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ModuleRepository extends MongoRepository<Module, UUID> {
}
