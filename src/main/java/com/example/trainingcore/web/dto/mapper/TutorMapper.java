package com.example.trainingcore.web.dto.mapper;

import com.example.trainingcore.model.Tutor;
import com.example.trainingcore.web.dto.TutorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TutorMapper extends Mappable<Tutor, TutorDTO> {

}
