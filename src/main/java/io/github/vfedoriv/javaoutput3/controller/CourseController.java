package io.github.vfedoriv.javaoutput3.controller;

import io.github.vfedoriv.javaoutput3.dto.CourseDTO;
import io.github.vfedoriv.javaoutput3.service.CourseService;
import io.github.vfedoriv.javaoutput3.response.ErrorResponse;
import io.github.vfedoriv.javaoutput3.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<?> saveCourse(@RequestBody CourseDTO courseDTO) {
        if (courseDTO.getName() == null || courseDTO.getName().isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Course name cannot be empty"));
        }
        try {
            Long newCourseId = courseService.addCourse(courseDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Course added with ID: " + newCourseId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Error adding course: " + e.getMessage()));
        }
    }

    @GetMapping("/searchByCourseId")
    public ResponseEntity<?> searchByCourseId(@RequestParam Long courseId) {
        if (courseId == null || courseId < 0) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Invalid course ID"));
        }
        List<StudentResponse> students = courseService.getStudentsByCourseId(courseId);
        if (students.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("No students found for course ID: " + courseId));
        }
        return ResponseEntity.ok(students);
    }

    @GetMapping("/searchByCourseName")
    public ResponseEntity<?> searchByCourseName(@RequestParam String courseName) {
        if (courseName == null || courseName.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Course name cannot be empty"));
        }
        List<StudentResponse> students = courseService.getStudentsByCourseName(courseName);
        if (students.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("No students found for course name: " + courseName));
        }
        return ResponseEntity.ok(students);
    }

    @GetMapping
    public ResponseEntity<?> loadCourses() {
        try {
            List<CourseDTO> courses = courseService.getAllCourses();
            return ResponseEntity.ok(courses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Error retrieving courses: " + e.getMessage()));
        }
    }
}