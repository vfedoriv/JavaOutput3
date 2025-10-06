package com.example.service;

import com.example.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectService {
    private List<Subject> subjects = new ArrayList<>();

    public void addSubject(Subject subject) {
        validateSubject(subject);
        subjects.add(subject);
    }

    private void validateSubject(Subject subject) {
        if (subject == null || subject.getName() == null || subject.getName().isEmpty()) {
            throw new IllegalArgumentException("Subject must have a valid name.");
        }
    }
}