package io.github.vfedoriv.javaoutput3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class SemesterService {

    @Autowired
    private SemesterRepository semesterRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> searchBySemester(String semester) {
        if (semester == null || semester.isEmpty()) {
            throw new IllegalArgumentException("Semester cannot be empty");
        }

        Long semesterId = semesterRepository.findIdByName(semester);
        if (semesterId == null) {
            throw new CustomNotFoundException("Semester not found");
        }

        Pageable pageable = PageRequest.of(0, 10);
        List<Student> students = studentRepository.findBySemesterId(semesterId, pageable);
        
        return students.isEmpty() ? List.of() : students;
    }
}