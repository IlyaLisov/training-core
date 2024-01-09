package com.example.trainingcore.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuizContentDTO extends ContentDTO {

    @Valid
    @NotNull(
            message = "Questions list must be not null."
    )
    @NotNull(
            message = "Questions list must be not empty."
    )
    private List<QuizQuestionDTO> questions;


}
