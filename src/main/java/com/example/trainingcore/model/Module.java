package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document("modules")
@Getter
@Setter
public class Module {

    @Id
    private UUID id;

    private String name;
    private Content content;
    private List<Module> submodules;
    private Course course;

}
