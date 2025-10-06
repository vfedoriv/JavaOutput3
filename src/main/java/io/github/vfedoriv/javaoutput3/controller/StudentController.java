package io.github.vfedoriv.javaoutput3.controller;

import io.github.vfedoriv.javaoutput3.dto.SubjectDTO;
import io.github.vfedoriv.javaoutput3.dto.StudentForm;
import io.github.vfedoriv.javaoutput3.service.StudentService;
import io.github.vfedoriv.javaoutput3.exception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/{studentId}/subjects")
    public ResponseEntity<String> addRemainingSubjects(@PathVariable Long studentId, @RequestBody List<SubjectDTO> subjects) {
        studentService.addSubjects(studentId, subjects);
        return ResponseEntity.ok("Subjects added successfully");
    }

    @GetMapping("/populate")
    public ResponseEntity<StudentForm> getNewStudentForm() {
        return ResponseEntity.ok(new StudentForm());
    }

    @PostMapping("/populate")
    public ResponseEntity<String> addNewStudent(@Valid @RequestBody StudentForm studentForm) {
        studentService.saveStudent(studentForm);
        return ResponseEntity.ok("Student added successfully");
    }

    @GetMapping("/view")
    public ResponseEntity<String> viewStudentForm() {
        return ResponseEntity.ok("Display student view form");
    }

    @GetMapping("/searchByStudentName")
    public ResponseEntity<?> searchByStudentName(@RequestParam String studentName) {
        if (studentName.isEmpty()) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Student name cannot be empty"));
        }
        List<StudentDTO> students = studentService.findByName(studentName);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchStudents(@RequestParam(required = false) Long studentId,
                                            @RequestParam(required = false) Long courseId,
                                            @RequestParam(required = false) String semester) {
        if (studentId == null && courseId == null && (semester == null || semester.isEmpty())) {
            return ResponseEntity.badRequest().body(new ErrorResponse("At least one search criterion must be provided"));
        }
        StudentDTO student = studentService.search(studentId, courseId, semester);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudentById(@PathVariable Long studentId) {
        if (studentId <= 0) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Invalid student ID"));
        }
        StudentDTO student = studentService.findById(studentId);
        return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
    }
}