package com.example.trainingcore.service;

import com.example.trainingcore.model.Course;
import com.example.trainingcore.model.Module;
import org.bson.types.ObjectId;

public interface CourseService extends CrudService<Course> {

    void addStudent(
            ObjectId id,
            ObjectId studentId
    );

    void removeStudent(
            ObjectId id,
            ObjectId studentId
    );

    void addModule(
            ObjectId id,
            Module module
    );

    boolean isTutor(
            ObjectId courseId,
            ObjectId userId
    );

    boolean isStudent(
            ObjectId courseId,
            ObjectId userId
    );

}
