package com.example.trainingcore.service.impl;

import com.example.trainingcore.model.User;
import com.example.trainingcore.model.exception.ResourceAlreadyExistsException;
import com.example.trainingcore.service.AuthService;
import com.example.trainingcore.service.MailService;
import com.example.trainingcore.service.UserService;
import com.example.trainingcore.service.data.MailData;
import com.example.trainingcore.web.security.jwt.AuthRequest;
import com.example.trainingcore.web.security.jwt.AuthResponse;
import com.example.trainingcore.web.security.jwt.RestoreRequest;
import com.example.trainingcore.web.security.jwt.TokenType;
import com.example.trainingcore.web.security.jwt.exception.InvalidTokenException;
import com.example.trainingcore.web.security.jwt.service.JwtService;
import com.example.trainingcore.web.security.jwt.service.params.JwtProperties;
import com.example.trainingcore.web.security.jwt.service.params.TokenParameters;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final JwtService jwtService;
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
        String token = jwtService.generate(
                TokenParameters.builder(
                                user.getUsername(),
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
                jwtService.generate(
                        TokenParameters.builder(
                                        request.getUsername(),
                                        jwtProperties.getAccess()
                                )
                                .type(TokenType.ACCESS)
                                .build()
                )
        );
        response.setRefresh(
                jwtService.generate(
                        TokenParameters.builder(
                                        request.getUsername(),
                                        jwtProperties.getRefresh()
                                )
                                .type(TokenType.REFRESH)
                                .build()
                )
        );
        return response;
    }

    @Override
    public void activate(
            final String token
    ) {
        Map<String, Object> fields = jwtService.fields(token);
        User user = userService.getByUsername(
                (String) fields.get("sub")
        );
        user.setActive(true);
        userService.update(user);
    }

    @Override
    public void restore(
            final String username
    ) {
        if (userService.existsByUsername(username)) {
            String token = jwtService.generate(
                    TokenParameters.builder(
                                    username,
                                    jwtProperties.getRestore()
                            )
                            .type(TokenType.RESTORE)
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
        if (!jwtService.isValid(request.getToken(), TokenType.RESTORE)) {
            throw new InvalidTokenException();
        }
        Map<String, Object> fields = jwtService.fields(request.getToken());
        User user = userService.getByUsername(
                (String) fields.get("sub")
        );
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );
        userService.update(user);
    }

}
