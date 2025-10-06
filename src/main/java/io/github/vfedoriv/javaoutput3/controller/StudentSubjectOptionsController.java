package io.github.vfedoriv.javaoutput3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/student-subject-options")
public class StudentSubjectOptionsController {

    @Autowired
    private StudentSubjectService studentSubjectService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean success = studentSubjectService.login(loginRequest);
        return success ? ResponseEntity.ok("Login successful") : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
    }

    @PostMapping("/subjects")
    public ResponseEntity<String> addSubject(@Valid @RequestBody Subject subject) {
        studentSubjectService.addSubject(subject);
        return ResponseEntity.status(HttpStatus.CREATED).body("Subject added successfully");
    }

    @GetMapping("/subjects/{studentId}")
    public ResponseEntity<List<Subject>> getSubjectsByStudentId(@PathVariable Long studentId) {
        List<Subject> subjects = studentSubjectService.getSubjectsByStudentId(studentId);
        return ResponseEntity.ok(subjects);
    }

    @PutMapping("/subjects/{subjectId}")
    public ResponseEntity<String> updateSubject(@PathVariable Long subjectId, @Valid @RequestBody Subject subject) {
        studentSubjectService.updateSubject(subjectId, subject);
        return ResponseEntity.ok("Subject updated successfully");
    }

    @DeleteMapping("/subjects/{subjectId}")
    public ResponseEntity<String> deleteSubject(@PathVariable Long subjectId) {
        studentSubjectService.deleteSubject(subjectId);
        return ResponseEntity.ok("Subject deleted successfully");
    }

    @GetMapping("/students/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam(required = false) Long id,
                                                       @RequestParam(required = false) String name,
                                                       @RequestParam(required = false) String course,
                                                       @RequestParam(required = false) String semester) {
        List<Student> students = studentSubjectService.searchStudents(id, name, course, semester);
        return ResponseEntity.ok(students);
    }
}