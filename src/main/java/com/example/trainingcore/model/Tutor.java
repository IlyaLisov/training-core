package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Tutor extends User {

    private List<Course> courses;

    public Tutor() {
        this.role = "ROLE_TUTOR";
        this.courses = new ArrayList<>();
    }

}
