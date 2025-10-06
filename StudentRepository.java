package com.example.repository;

import java.util.List;

public interface StudentRepository {
    Student findById(Long studentId);
    List<Student> findByCourseId(Long courseId);
}