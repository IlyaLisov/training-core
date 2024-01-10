package com.example.trainingcore.service;

import com.example.trainingcore.model.User;

public interface UserService extends CrudService<User> {

    User getByUsername(String username);

    boolean existsByUsername(String username);

}
