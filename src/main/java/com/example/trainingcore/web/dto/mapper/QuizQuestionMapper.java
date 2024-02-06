package com.example.trainingcore.web.dto.mapper;

import com.example.trainingcore.model.QuizQuestion;
import com.example.trainingcore.web.dto.QuizQuestionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizQuestionMapper
        extends Mappable<QuizQuestion, QuizQuestionDTO> {
}
