package com.example.trainingcore.service.impl;

import com.example.trainingcore.model.Course;
import com.example.trainingcore.model.Module;
import com.example.trainingcore.model.exception.ResourceNotFoundException;
import com.example.trainingcore.repository.CourseRepository;
import com.example.trainingcore.service.CourseService;
import com.example.trainingcore.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentService studentService;

    @Override
    public Course getById(
            final ObjectId id
    ) {
        return courseRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Course> getAll(
            final Pageable page
    ) {
        return courseRepository.findAll(page)
                .getContent();
    }

    @Override
    public Course create(
            final Course entity
    ) {
        return courseRepository.save(entity);
    }

    @Override
    public Course update(
            final Course entity
    ) {
        Course course = getById(entity.getId());
        course.setName(entity.getName());
        return courseRepository.save(course);
    }

    @Override
    public boolean existsById(
            final ObjectId id
    ) {
        return courseRepository.existsById(id);
    }

    @Override
    public void delete(
            final ObjectId id
    ) {
        courseRepository.deleteById(id);
    }

    @Override
    public void addStudent(
            final ObjectId id,
            final ObjectId studentId
    ) {
        Course course = getById(id);
        course.getStudents().add(
                studentService.getById(studentId)
        );
        courseRepository.save(course);
    }

    @Override
    public void removeStudent(
            final ObjectId id,
            final ObjectId studentId
    ) {
        Course course = getById(id);
        course.getStudents().remove(
                studentService.getById(studentId)
        );
        courseRepository.save(course);
    }

    @Override
    public void addModule(
            final ObjectId id,
            final Module module
    ) {
        Course course = getById(id);
        course.getModules().add(module);
        courseRepository.save(course);
    }

    @Override
    public boolean isTutor(
            final ObjectId courseId,
            final ObjectId userId
    ) {
        return courseRepository.existsByIdAndTutorId(courseId, userId);
    }

    @Override
    public boolean isStudent(
            final ObjectId courseId,
            final ObjectId userId
    ) {
        return courseRepository.existsByIdAndStudentsIdContains(
                courseId,
                userId
        );
    }

}
