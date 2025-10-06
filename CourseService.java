package com.example.courseservice;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private List<Course> courses;

    public CourseService() {
        this.courses = new ArrayList<>();
    }

    public boolean addCourse(Course course) {
        if (validateCourse(course)) {
            courses.add(course);
            return true;
        }
        return false;
    }

    private boolean validateCourse(Course course) {
        return course != null && course.getName() != null && !course.getName().isEmpty();
    }
}

class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}