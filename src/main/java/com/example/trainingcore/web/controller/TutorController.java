package com.example.trainingcore.web.controller;

import com.example.trainingcore.model.Tutor;
import com.example.trainingcore.service.TutorService;
import com.example.trainingcore.web.dto.CourseDTO;
import com.example.trainingcore.web.dto.TutorDTO;
import com.example.trainingcore.web.dto.mapper.CourseMapper;
import com.example.trainingcore.web.dto.mapper.TutorMapper;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tutors")
@PreAuthorize("hasRole('TUTOR')")
@RequiredArgsConstructor
public class TutorController {

    private final TutorService tutorService;
    private final TutorMapper tutorMapper;
    private final CourseMapper courseMapper;

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.canAccessTutor(#id)")
    public TutorDTO getById(
            @PathVariable final ObjectId id
    ) {
        Tutor tutor = tutorService.getById(id);
        return tutorMapper.toDto(tutor);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@ssi.canAccessTutor(#id)")
    public void deleteById(
            @PathVariable final ObjectId id
    ) {
        tutorService.delete(id);
    }

    @GetMapping("/{id}/courses")
    @PreAuthorize("@ssi.canAccessTutor(#id)")
    public List<CourseDTO> getCoursesById(
            @PathVariable final ObjectId id
    ) {
        Tutor tutor = tutorService.getById(id);
        return courseMapper.toDto(tutor.getCourses());
    }

}
