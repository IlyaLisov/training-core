package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@Setter
public abstract class Content {

    @Id
    protected UUID id;

}
