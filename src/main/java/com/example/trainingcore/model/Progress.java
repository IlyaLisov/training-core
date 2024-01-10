package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("progress")
@Getter
@Setter
public class Progress {

    @Id
    private ObjectId id;

    private List<Module> passedModules;

}
