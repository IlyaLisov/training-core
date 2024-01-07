package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document("courses")
@Getter
@Setter
public class Course {

    @Id
    private UUID id;

    private String name;
    private Tutor tutor;
    private List<Module> modules;
    private List<Student> students;

}
