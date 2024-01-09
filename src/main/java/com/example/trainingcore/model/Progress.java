package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document("progress")
@Getter
@Setter
public class Progress {

    @Id
    private UUID id;

    private List<Module> passedModules;

}
