package com.example.trainingcore.web.dto.mapper;

import com.example.trainingcore.model.CourseInfo;
import com.example.trainingcore.web.dto.CourseInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseInfoMapper extends Mappable<CourseInfo, CourseInfoDTO> {
}
