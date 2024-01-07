package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("students")
@Getter
@Setter
public class Student extends User {

    private List<CourseInfo> coursesInfo;

}
