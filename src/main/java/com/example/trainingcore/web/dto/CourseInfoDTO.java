package com.example.trainingcore.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CourseInfoDTO {

    @JsonProperty(
            access = JsonProperty.Access.READ_ONLY
    )
    private UUID id;

    @JsonProperty(
            access = JsonProperty.Access.READ_ONLY
    )
    private StudentDTO studentDTO;

    @JsonProperty(
            access = JsonProperty.Access.READ_ONLY
    )
    private CourseDTO courseDTO;

    @JsonProperty(
            access = JsonProperty.Access.READ_ONLY
    )
    private ProgressDTO progress;

}
