package com.example.trainingcore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("quiz_contents")
@Getter
@Setter
public class QuizContent extends Content {

    private List<QuizQuestion> questions;

}
