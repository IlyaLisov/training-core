package com.example.trainingcore.web.dto.mapper;

import com.example.trainingcore.model.Course;
import com.example.trainingcore.web.dto.CourseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper extends Mappable<Course, CourseDTO> {
}
