package com.example.trainingcore.web.dto.mapper;

import com.example.trainingcore.model.Progress;
import com.example.trainingcore.web.dto.ProgressDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgressMapper extends Mappable<Progress, ProgressDTO> {
}
