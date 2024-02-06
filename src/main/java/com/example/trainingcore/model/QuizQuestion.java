package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
@Setter
public class QuizQuestion {

    private ObjectId id;
    private String title;
    private List<String> options;
    private List<Integer> answerIndexes;

}
