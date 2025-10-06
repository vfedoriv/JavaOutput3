package io.github.vfedoriv.javaoutput3;

import io.github.vfedoriv.javaoutput3.exception.DuplicateStudentException;
import io.github.vfedoriv.javaoutput3.exception.StudentNotFoundException;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (studentRepository.findById(student.getId()) != null) {
            throw new DuplicateStudentException("Student with ID " + student.getId() + " already exists");
        }
        studentRepository.save(student);
    }

    public void updateStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (studentRepository.findById(student.getId()) == null) {
            throw new StudentNotFoundException("Student with ID " + student.getId() + " not found");
        }
        studentRepository.save(student);
    }
}