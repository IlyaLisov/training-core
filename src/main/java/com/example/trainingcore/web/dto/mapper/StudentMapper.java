package com.example.trainingcore.web.dto.mapper;

import com.example.trainingcore.model.Student;
import com.example.trainingcore.web.dto.StudentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper extends Mappable<Student, StudentDTO> {
}
