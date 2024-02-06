package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("modules")
@Getter
@Setter
public class Module {

    @Id
    private ObjectId id;

    private String name;
    private Content content;
    private List<Module> submodules;
    private Course course;

}
