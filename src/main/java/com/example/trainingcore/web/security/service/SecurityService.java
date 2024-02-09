package com.example.trainingcore.web.security.service;

import com.example.trainingcore.web.security.SecurityUser;
import org.bson.types.ObjectId;

public interface SecurityService {

    SecurityUser getUserFromRequest();

    boolean canAccessTutor(ObjectId tutorId);

}
