package com.example.trainingcore.web.security.jwt.service;

import com.example.trainingcore.web.security.jwt.TokenType;
import com.example.trainingcore.web.security.jwt.service.params.TokenParameters;

import java.util.HashMap;

public interface JwtService {

    String generate(TokenParameters params);

    boolean isValid(String token, TokenType type);

    HashMap<String, Object> fields(String token);

}