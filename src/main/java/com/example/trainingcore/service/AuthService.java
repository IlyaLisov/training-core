package com.example.trainingcore.service;

import com.example.trainingcore.model.User;
import com.example.trainingcore.web.security.jwt.AuthRequest;
import com.example.trainingcore.web.security.jwt.AuthResponse;
import com.example.trainingcore.web.security.jwt.RestoreRequest;

public interface AuthService {

    void register(User user);

    AuthResponse login(AuthRequest request);

    AuthResponse refresh(String token);

    void activate(String token);

    void restore(String username);

    void reset(RestoreRequest request);

}
