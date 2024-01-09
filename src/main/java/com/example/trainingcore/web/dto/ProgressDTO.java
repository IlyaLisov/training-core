package com.example.trainingcore.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProgressDTO {

    @JsonProperty(
            access = JsonProperty.Access.READ_ONLY
    )
    private UUID id;


    @JsonProperty(
            access = JsonProperty.Access.READ_ONLY
    )
    private List<ModuleDTO> passedModules;

}