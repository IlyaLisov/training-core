package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.UUID;

@Getter
@Setter
public abstract class User {

    protected UUID id;
    protected String fullName;

    @Indexed(unique = true)
    protected String username;

    protected String password;

}
