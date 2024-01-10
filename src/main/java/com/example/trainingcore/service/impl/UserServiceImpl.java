package com.example.trainingcore.service.impl;

import com.example.trainingcore.model.User;
import com.example.trainingcore.model.exception.ResourceNotFoundException;
import com.example.trainingcore.repository.UserRepository;
import com.example.trainingcore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getById(
            final ObjectId id
    ) {
        return userRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public User getByUsername(
            final String username
    ) {
        return userRepository.findByUsername(username)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<User> getAll(
            final Pageable page
    ) {
        //TODO implement
        return null;
    }

    @Override
    public User create(
            final User entity
    ) {
        if (entity.getId() == null && !existsByUsername(entity.getUsername())) {
            userRepository.save(entity);
        }
        return entity;
    }

    @Override
    public User update(
            final User entity
    ) {
        //TODO implement
        return null;
    }

    @Override
    public boolean existsById(
            final ObjectId id
    ) {
        return userRepository.existsById(id);
    }

    @Override
    public boolean existsByUsername(
            final String username
    ) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void delete(
            final ObjectId id
    ) {
        userRepository.deleteById(id);
    }

}
