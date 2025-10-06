package com.example.studentmanagement;

import java.util.HashMap;
import java.util.Map;

public class StudentService {
    private Map<Long, Student> studentDatabase = new HashMap<>();
    private long currentId = 1;

    public void addStudent(Student student) {
        if (student == null || student.getName() == null || student.getName().isEmpty()) {
            throw new IllegalArgumentException("Invalid student data");
        }
        student.setId(currentId++);
        studentDatabase.put(student.getId(), student);
    }

    public Student findStudentById(Long studentId) {
        return studentDatabase.get(studentId);
    }
}

class Student {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}