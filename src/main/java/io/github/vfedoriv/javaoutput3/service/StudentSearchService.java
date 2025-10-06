package io.github.vfedoriv.javaoutput3.service;

import io.github.vfedoriv.javaoutput3.exception.StudentNotFoundException;
import io.github.vfedoriv.javaoutput3.model.SearchParams;
import io.github.vfedoriv.javaoutput3.repository.StudentRepository;
import io.github.vfedoriv.javaoutput3.model.Student;

import java.util.List;

public class StudentSearchService {
    private final StudentRepository studentRepository;

    public StudentSearchService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> searchStudents(SearchParams searchParams) {
        if (!studentRepository.semesterExists(searchParams.getSemester())) {
            throw new StudentNotFoundException("Invalid semester provided.");
        }

        List<Student> students = studentRepository.findStudentsByCriteria(searchParams);
        if (students.isEmpty()) {
            throw new StudentNotFoundException("No students found matching the criteria.");
        }

        return students;
    }
}