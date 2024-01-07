package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("tutors")
@Getter
@Setter
public class Tutor extends User {

    private List<Course> courses;

}
