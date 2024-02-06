package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("courses")
@Getter
@Setter
public class Course {

    @Id
    private ObjectId id;

    private String name;
    private Tutor tutor;
    private List<Module> modules;
    private List<Student> students;

}
