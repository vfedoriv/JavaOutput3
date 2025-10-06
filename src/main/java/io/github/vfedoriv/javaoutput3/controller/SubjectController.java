package io.github.vfedoriv.javaoutput3.controller;

import io.github.vfedoriv.javaoutput3.dto.SubjectDTO;
import io.github.vfedoriv.javaoutput3.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public ResponseEntity<String> addSubject(@RequestBody SubjectDTO subjectDTO) {
        if (subjectDTO.getName() == null || subjectDTO.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Subject name cannot be empty.");
        }
        if (subjectService.isDuplicate(subjectDTO.getName())) {
            return ResponseEntity.badRequest().body("Subject already exists.");
        }
        subjectService.addSubject(subjectDTO);
        return ResponseEntity.status(201).body("Subject added successfully.");
    }

    @GetMapping("/load")
    public ResponseEntity<List<SubjectDTO>> loadSubjects() {
        List<SubjectDTO> subjects = subjectService.getAllSubjects();
        if (subjects.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(subjects);
    }

    @PostMapping("/addSubjectToStudent")
    public ResponseEntity<String> addSubjectToStudent(@RequestParam Long studentId, 
                                                       @RequestParam Long subjectId, 
                                                       @RequestParam Long semesterId, 
                                                       @RequestParam Integer marks) {
        subjectService.addSubjectToStudent(studentId, subjectId, semesterId, marks);
        return ResponseEntity.ok("Subject added to student successfully.");
    }

    @DeleteMapping("/{studentId}/{subjectId}")
    public ResponseEntity<String> deleteSubject(@PathVariable Long studentId, 
                                                 @PathVariable Long subjectId) {
        if (studentId == null || subjectId == null) {
            return ResponseEntity.badRequest().body("Student ID and Subject ID cannot be null.");
        }
        subjectService.deleteSubject(studentId, subjectId);
        return ResponseEntity.ok("Subject deleted successfully.");
    }

    @GetMapping("/available")
    public ResponseEntity<List<SubjectDTO>> getAvailableSubjects(@RequestParam Long currentCourseId, 
                                                                  @RequestParam Long avaSemId) {
        if (currentCourseId == null || avaSemId == null) {
            return ResponseEntity.badRequest().body(null);
        }
        List<SubjectDTO> availableSubjects = subjectService.getAvailableSubjects(currentCourseId, avaSemId);
        if (availableSubjects.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(availableSubjects);
    }
}