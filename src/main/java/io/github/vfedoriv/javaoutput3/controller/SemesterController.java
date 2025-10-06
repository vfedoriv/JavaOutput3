package io.github.vfedoriv.javaoutput3.controller;

import io.github.vfedoriv.javaoutput3.service.SemesterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/semesters")
public class SemesterController {

    private static final Logger logger = LoggerFactory.getLogger(SemesterController.class);

    @Autowired
    private SemesterService semesterService;

    @GetMapping("/searchBySemester")
    public ResponseEntity<?> searchBySemester(@RequestParam String semester) {
        if (semester == null || semester.trim().isEmpty()) {
            logger.error("Invalid semester input: {}", semester);
            return ResponseEntity.badRequest().body("Semester input cannot be empty.");
        }

        try {
            List<Student> students = semesterService.searchBySemester(semester);
            if (students.isEmpty()) {
                logger.warn("No students found for semester: {}", semester);
                return ResponseEntity.ok("No students found for the specified semester.");
            }
            logger.info("Successfully retrieved students for semester: {}", semester);
            return ResponseEntity.ok(students);
        } catch (Exception e) {
            logger.error("Error occurred while searching for semester: {}", semester, e);
            return ResponseEntity.status(500).body("An error occurred while processing your request.");
        }
    }
}