package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class User {

    protected UUID id;
    protected String fullName;
    protected String username;
    protected String password;

}
