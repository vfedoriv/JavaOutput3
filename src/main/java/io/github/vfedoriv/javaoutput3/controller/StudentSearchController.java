package io.github.vfedoriv.javaoutput3.controller;

import io.github.vfedoriv.javaoutput3.service.StudentSearchService;
import io.github.vfedoriv.javaoutput3.model.ErrorResponse;
import io.github.vfedoriv.javaoutput3.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentSearchController {

    @Autowired
    private StudentSearchService studentSearchService;

    @GetMapping("/api/students/search")
    public ResponseEntity<?> searchStudents(
            @RequestParam(required = false) String studentName,
            @RequestParam(required = false) String courseId,
            @RequestParam(required = false) String semester) {

        if (studentName == null || studentName.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Student name cannot be empty"));
        }

        if (studentName.isEmpty() && (courseId == null || courseId.isEmpty()) && (semester == null || semester.isEmpty())) {
            return ResponseEntity.badRequest().body(new ErrorResponse("At least one search parameter must be provided."));
        }

        List<Student> students = studentSearchService.searchStudents(studentName, courseId, semester);

        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(students);
    }
}