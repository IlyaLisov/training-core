package com.example.trainingcore.web.controller;

import com.example.trainingcore.model.Course;
import com.example.trainingcore.model.Module;
import com.example.trainingcore.model.Tutor;
import com.example.trainingcore.service.CourseService;
import com.example.trainingcore.service.ModuleService;
import com.example.trainingcore.web.dto.CourseDTO;
import com.example.trainingcore.web.dto.ModuleDTO;
import com.example.trainingcore.web.dto.OnCreate;
import com.example.trainingcore.web.dto.StudentDTO;
import com.example.trainingcore.web.dto.mapper.CourseMapper;
import com.example.trainingcore.web.dto.mapper.ModuleMapper;
import com.example.trainingcore.web.dto.mapper.StudentMapper;
import com.example.trainingcore.web.security.SecurityUser;
import com.example.trainingcore.web.security.service.SecurityService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final ModuleService moduleService;
    private final SecurityService securityService;
    private final CourseMapper courseMapper;
    private final StudentMapper studentMapper;
    private final ModuleMapper moduleMapper;

    @PostMapping
    @PreAuthorize("hasRole('TUTOR')")
    public CourseDTO create(
            @RequestBody @Validated(OnCreate.class) final CourseDTO courseDTO
    ) {
        Course course = courseMapper.fromDto(courseDTO);
        SecurityUser author = securityService.getUserFromRequest();
        course.setTutor(new Tutor(author.getId()));
        course = courseService.create(course);
        return courseMapper.toDto(course);
    }

    @GetMapping("/{id}")
    @PreAuthorize("@ssi.courseAuthor(#id) || @ssi.courseStudent(#id)")
    public CourseDTO getById(
            @PathVariable final ObjectId id
    ) {
        Course course = courseService.getById(id);
        return courseMapper.toDto(course);
    }

    @GetMapping("/{id}/students")
    @PreAuthorize("@ssi.courseAuthor(#id)")
    public List<StudentDTO> getStudentsById(
            @PathVariable final ObjectId id
    ) {
        Course course = courseService.getById(id);
        return studentMapper.toDto(course.getStudents());
    }

    @PostMapping("/{id}/students/{studentId}")
    @PreAuthorize("@ssi.courseAuthor(#id)")
    public void addStudentToCourse(
            @PathVariable final ObjectId id,
            @PathVariable final ObjectId studentId
    ) {
        courseService.addStudent(id, studentId);
    }

    @DeleteMapping("/{id}/students/{studentId}")
    @PreAuthorize("@ssi.courseAuthor(#id)")
    public void removeStudentFromCourse(
            @PathVariable final ObjectId id,
            @PathVariable final ObjectId studentId
    ) {
        courseService.removeStudent(id, studentId);
    }

    @GetMapping("/{id}/modules")
    @PreAuthorize("@ssi.courseAuthor(#id) || @ssi.courseStudent(#id)")
    public List<ModuleDTO> getModulesById(
            @PathVariable final ObjectId id
    ) {
        Course course = courseService.getById(id);
        return moduleMapper.toDto(course.getModules());
    }

    @PostMapping("/{id}/modules")
    @Transactional
    @PreAuthorize("@ssi.courseAuthor(#id)")
    public ModuleDTO createModule(
            @PathVariable final ObjectId id,
            @RequestBody final ModuleDTO moduleDTO
    ) {
        Module module = moduleMapper.fromDto(moduleDTO);
        module = moduleService.create(module);
        courseService.addModule(id, module);
        return moduleMapper.toDto(module);
    }

}
