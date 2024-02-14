package com.example.trainingcore.service.impl;

import com.example.trainingcore.model.Student;
import com.example.trainingcore.model.exception.ResourceNotFoundException;
import com.example.trainingcore.repository.StudentRepository;
import com.example.trainingcore.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student getById(
            final ObjectId id
    ) {
        return studentRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Student getByUsername(
            final String username
    ) {
        return studentRepository.findByUsername(username)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public boolean existsByUsername(
            final String username
    ) {
        return studentRepository.existsByUsername(username);
    }

    @Override
    public List<Student> getAll(
            final Pageable page
    ) {
        return studentRepository.findAll(page)
                .getContent();
    }

    @Override
    public Student create(
            final Student entity
    ) {
        if (entity.getId() == null && !existsByUsername(entity.getUsername())) {
            studentRepository.save(entity);
        }
        return entity;
    }

    @Override
    public Student update(
            final Student entity
    ) {
        Student student = getById(entity.getId());
        student.setUsername(entity.getUsername());
        student.setFullName(entity.getFullName());
        student.setActive(entity.isActive());
        return studentRepository.save(student);
    }

    @Override
    public boolean existsById(
            final ObjectId id
    ) {
        return studentRepository.existsById(id);
    }

    @Override
    public void delete(
            final ObjectId id
    ) {
        studentRepository.deleteById(id);
    }

}
