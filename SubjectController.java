package com.example.controller;

import com.example.model.Subject;
import com.example.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/subjects")
    public ResponseEntity<Void> addSubject(@RequestBody Subject subject) {
        subjectService.saveSubject(subject);
        return ResponseEntity.ok().build();
    }
}