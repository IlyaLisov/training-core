package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class QuizQuestion {

    private UUID id;
    private String title;
    private List<String> options;
    private List<Integer> answerIndexes;

}
