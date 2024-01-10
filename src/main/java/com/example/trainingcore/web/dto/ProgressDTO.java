package com.example.trainingcore.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.List;

@Getter
@Setter
public class ProgressDTO {

    @JsonProperty(
            access = JsonProperty.Access.READ_ONLY
    )
    private ObjectId id;


    @JsonProperty(
            access = JsonProperty.Access.READ_ONLY
    )
    private List<ModuleDTO> passedModules;

}
