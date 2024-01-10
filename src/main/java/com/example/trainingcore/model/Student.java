package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Student extends User {

    private List<CourseInfo> coursesInfo;

    public Student() {
        this.role = "ROLE_STUDENT";
        this.coursesInfo = new ArrayList<>();
    }

}
