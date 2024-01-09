package com.example.trainingcore.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDTO extends UserDTO {

    @JsonProperty(
            access = JsonProperty.Access.READ_ONLY
    )
    private List<CourseInfoDTO> coursesInfo;

}
