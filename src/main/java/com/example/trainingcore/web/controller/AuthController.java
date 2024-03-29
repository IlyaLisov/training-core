package com.example.trainingcore.web.controller;

import com.example.trainingcore.model.User;
import com.example.trainingcore.service.AuthService;
import com.example.trainingcore.web.dto.OnCreate;
import com.example.trainingcore.web.dto.StudentDTO;
import com.example.trainingcore.web.dto.TutorDTO;
import com.example.trainingcore.web.dto.mapper.UserMapper;
import com.example.trainingcore.web.security.jwt.AuthRequest;
import com.example.trainingcore.web.security.jwt.AuthResponse;
import com.example.trainingcore.web.security.jwt.RestoreRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserMapper userMapper;

    private final AuthService authService;

    @PostMapping("/register/tutor")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerTutor(
            @RequestBody @Validated(OnCreate.class) final TutorDTO tutorDTO
    ) {
        User user = userMapper.fromDto(tutorDTO);
        authService.register(user);
    }

    @PostMapping("/register/student")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerStudent(
            @RequestBody @Validated(OnCreate.class) final StudentDTO studentDTO
    ) {
        User user = userMapper.fromDto(studentDTO);
        authService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody @Validated final AuthRequest request
    ) {
        return authService.login(request);
    }

    @PostMapping("/activate")
    public void activate(
            @RequestBody @Validated final String token
    ) {
        authService.activate(token);
    }

    @PostMapping("/restore")
    public void restore(
            @RequestBody final String username
    ) {
        authService.restore(username);
    }

    @PostMapping("/reset")
    public void reset(
            @RequestBody final RestoreRequest request
    ) {
        authService.reset(request);
    }

}
