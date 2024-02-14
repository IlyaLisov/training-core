package com.example.trainingcore.service.impl;

import com.example.trainingcore.model.Tutor;
import com.example.trainingcore.model.exception.ResourceNotFoundException;
import com.example.trainingcore.repository.TutorRepository;
import com.example.trainingcore.service.TutorService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorServiceImpl implements TutorService {

    private final TutorRepository tutorRepository;

    @Override
    public Tutor getById(
            final ObjectId id
    ) {
        return tutorRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Tutor getByUsername(
            final String username
    ) {
        return tutorRepository.findByUsername(username)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Tutor> getAll(
            final Pageable page
    ) {
        return tutorRepository.findAll(page)
                .getContent();
    }

    @Override
    public Tutor create(
            final Tutor entity
    ) {
        if (entity.getId() == null && !existsByUsername(entity.getUsername())) {
            tutorRepository.save(entity);
        }
        return entity;
    }

    @Override
    public Tutor update(
            final Tutor entity
    ) {
        Tutor tutor = getById(entity.getId());
        tutor.setUsername(entity.getUsername());
        tutor.setFullName(entity.getFullName());
        tutor.setActive(entity.isActive());
        return tutorRepository.save(tutor);
    }

    @Override
    public boolean existsById(
            final ObjectId id
    ) {
        return tutorRepository.existsById(id);
    }

    @Override
    public boolean existsByUsername(
            final String username
    ) {
        return tutorRepository.existsByUsername(username);
    }

    @Override
    public void delete(
            final ObjectId id
    ) {
        tutorRepository.deleteById(id);
    }

}
