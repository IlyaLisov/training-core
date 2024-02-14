package com.example.trainingcore.web.security.service;

import com.example.trainingcore.service.CourseService;
import com.example.trainingcore.web.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service("ssi")
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final CourseService courseService;

    @Override
    public SecurityUser getUserFromRequest() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if (!authentication.isAuthenticated()) {
            return null;
        }
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return null;
        }
        return (SecurityUser) authentication
                .getPrincipal();
    }

    @Override
    public boolean canAccessTutor(
            final ObjectId tutorId
    ) {
        SecurityUser user = getUserFromRequest();
        ObjectId id = user.getId();
        return tutorId.equals(id);
    }

    @Override
    public boolean courseAuthor(
            final ObjectId courseId
    ) {
        SecurityUser user = getUserFromRequest();
        ObjectId id = user.getId();
        return courseService.isTutor(courseId, id);
    }

    @Override
    public boolean courseStudent(
            final ObjectId courseId
    ) {
        SecurityUser user = getUserFromRequest();
        ObjectId id = user.getId();
        return courseService.isStudent(courseId, id);
    }

}
