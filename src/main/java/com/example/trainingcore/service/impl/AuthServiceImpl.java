package com.example.trainingcore.service.impl;

import com.example.trainingcore.model.User;
import com.example.trainingcore.model.exception.ResourceAlreadyExistsException;
import com.example.trainingcore.service.AuthService;
import com.example.trainingcore.service.MailService;
import com.example.trainingcore.service.UserService;
import com.example.trainingcore.service.data.MailData;
import com.example.trainingcore.web.security.jwt.AuthRequest;
import com.example.trainingcore.web.security.jwt.AuthResponse;
import com.example.trainingcore.web.security.jwt.JwtProperties;
import com.example.trainingcore.web.security.jwt.RestoreRequest;
import com.example.trainingcore.web.security.jwt.TokenType;
import com.example.trainingcore.web.security.jwt.exception.InvalidTokenException;
import io.github.ilyalisov.jwt.config.TokenParameters;
import io.github.ilyalisov.jwt.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final TokenService jwtService;
    private final MailService mailService;
    private final JwtProperties jwtProperties;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public void register(
            final User user
    ) {
        if (userService.existsByUsername(user.getUsername())) {
            throw new ResourceAlreadyExistsException();
        }
        user.setActive(false);
        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );
        userService.create(user);
        String token = jwtService.create(
                TokenParameters.builder(
                                user.getUsername(),
                                TokenType.ACTIVATION.name(),
                                jwtProperties.getActivation()
                        )
                        .build()
        );
        mailService.send(
                MailData.builder(
                                user.getUsername(),
                                MailData.Type.ACTIVATION
                        )
                        .param(
                                "token",
                                token
                        )
                        .build()
        );
    }

    @Override
    public AuthResponse login(
            final AuthRequest request
    ) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        AuthResponse response = new AuthResponse();
        response.setAccess(
                jwtService.create(
                        TokenParameters.builder(
                                        request.getUsername(),
                                        TokenType.ACCESS.name(),
                                        jwtProperties.getAccess()
                                )
                                .build()
                )
        );
        response.setRefresh(
                jwtService.create(
                        TokenParameters.builder(
                                        request.getUsername(),
                                        TokenType.REFRESH.name(),
                                        jwtProperties.getRefresh()
                                )
                                .build()
                )
        );
        return response;
    }

    @Override
    public void activate(
            final String token
    ) {
        String subject = jwtService.getSubject(token);
        User user = userService.getByUsername(subject);
        user.setActive(true);
        userService.update(user);
    }

    @Override
    public void restore(
            final String username
    ) {
        if (userService.existsByUsername(username)) {
            String token = jwtService.create(
                    TokenParameters.builder(
                                    username,
                                    TokenType.RESTORE.name(),
                                    jwtProperties.getRestore()
                            )
                            .build()
            );
            mailService.send(
                    MailData.builder(
                                    username,
                                    MailData.Type.RESTORE
                            )
                            .param(
                                    "token",
                                    token
                            )
                            .build()
            );
        }
    }

    @Override
    public void reset(
            final RestoreRequest request
    ) {
        if (!jwtService.getType(request.getToken())
                .equals(TokenType.RESTORE.name())
                || jwtService.isExpired(request.getToken())) {
            throw new InvalidTokenException();
        }
        String subject = jwtService.getSubject(request.getToken());
        User user = userService.getByUsername(subject);
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );
        userService.update(user);
    }

}
