package io.github.vfedoriv.javaoutput3.controller;

import io.github.vfedoriv.javaoutput3.dto.ChangeSemesterRequest;
import io.github.vfedoriv.javaoutput3.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@Validated
public class ChangeSemesterController {

    private final StudentService studentService;

    public ChangeSemesterController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/change-semester")
    public CompletableFuture<ResponseEntity<String>> changeSemester(@Valid @RequestBody ChangeSemesterRequest request) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                studentService.changeSemester(request.getStudentId(), request.getNewSemester());
                return ResponseEntity.ok("Semester changed successfully");
            } catch (Exception e) {
                return ResponseEntity.status(500).body("Error changing semester: " + e.getMessage());
            }
        }).orTimeout(2, java.util.concurrent.TimeUnit.SECONDS);
    }
}