package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("coursesInfo")
@Getter
@Setter
public class CourseInfo {

    @Id
    private UUID id;

    private Student user;
    private Course course;
    private Progress progress;

}
