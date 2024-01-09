package com.example.trainingcore.web.dto.mapper;

import com.example.trainingcore.model.QuizContent;
import com.example.trainingcore.web.dto.QuizContentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizContentMapper
        extends Mappable<QuizContent, QuizContentDTO> {
}
