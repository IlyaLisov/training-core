package com.example.trainingcore.web.dto.mapper;

import com.example.trainingcore.model.Student;
import com.example.trainingcore.model.Tutor;
import com.example.trainingcore.model.User;
import com.example.trainingcore.web.dto.StudentDTO;
import com.example.trainingcore.web.dto.TutorDTO;
import com.example.trainingcore.web.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    default User fromDto(
            final UserDTO d
    ) {
        if (d == null) {
            return null;
        } else if (d instanceof TutorDTO) {
            return Mappers.getMapper(TutorMapper.class)
                    .fromDto((TutorDTO) d);
        } else if (d instanceof StudentDTO) {
            return Mappers.getMapper(StudentMapper.class)
                    .fromDto((StudentDTO) d);
        } else {
            return null;
        }
    }

    default UserDTO toDto(
            final User e
    ) {
        if (e == null) {
            return null;
        } else if (e instanceof Student) {
            return Mappers.getMapper(StudentMapper.class)
                    .toDto((Student) e);
        } else if (e instanceof Tutor) {
            return Mappers.getMapper(TutorMapper.class)
                    .toDto((Tutor) e);
        } else {
            return null;
        }
    }

}
