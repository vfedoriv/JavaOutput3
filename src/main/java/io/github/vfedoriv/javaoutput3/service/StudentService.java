package io.github.vfedoriv.javaoutput3.service;

import io.github.vfedoriv.javaoutput3.exception.AlreadyInSemesterException;
import io.github.vfedoriv.javaoutput3.exception.InvalidSemesterException;
import io.github.vfedoriv.javaoutput3.exception.StudentNotFoundException;
import io.github.vfedoriv.javaoutput3.repository.CourseRepository;
import io.github.vfedoriv.javaoutput3.repository.StudentRepository;
import io.github.vfedoriv.javaoutput3.dto.StudentDTO;
import io.github.vfedoriv.javaoutput3.dto.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public String addStudent(StudentDTO studentDTO) {
        validateStudentInput(studentDTO);
        checkDuplicateStudent(studentDTO);
        Long newStudentId = getNextStudentId();
        studentDTO.setId(newStudentId);
        studentRepository.save(studentDTO);
        logAction("Student added: " + studentDTO.getName());
        return "Student added successfully";
    }

    public String addRemainingSubjects(Long studentId, List<SubjectDTO> subjects) {
        validateSubjectsInput(subjects);
        checkDuplicateSubjects(studentId, subjects);
        studentRepository.updateSubjects(studentId, subjects);
        logAction("Remaining subjects added for student ID: " + studentId);
        return "Subjects added successfully";
    }

    public List<StudentDTO> searchStudents(String name, Long id, Long courseId, String semester) {
        return studentRepository.searchByCriteria(name, id, courseId, semester);
    }

    public List<StudentDTO> searchByStudentName(String studentName) {
        validateStudentName(studentName);
        List<StudentDTO> students = studentRepository.findByNameIgnoreCase(studentName);
        logAction("Search by student name: " + studentName + ", found: " + students.size());
        return students;
    }

    public StudentDTO searchByStuIdCrsIdSem(Long studentId, Long courseId, String semester) {
        validateSearchParameters(studentId, courseId, semester);
        return studentRepository.findByIdAndCourseIdAndSemester(studentId, courseId, semester)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public StudentDTO searchByStuIdCrsNameSem(Integer studentId, String courseName, String semester) {
        validateSearchParameters(studentId, courseName, semester);
        return studentRepository.findByIdAndCourseNameAndSemester(studentId, courseName, semester)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public List<StudentDTO> searchByStudentNameCourseAndSemester(String studentName, Integer courseId, String semester) {
        return studentRepository.findByNameAndCourseIdAndSemester(studentName, courseId, semester);
    }

    public StudentDTO findStudentById(Long studentId) {
        validateStudentId(studentId);
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
    }

    public Optional<StudentDTO> findById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public String changeSemester(Long studentId, String newSemester) {
        validateStudentId(studentId);
        validateSemester(newSemester);
        if (studentRepository.isInSemester(studentId, newSemester)) {
            throw new AlreadyInSemesterException("Student is already in the specified semester");
        }
        studentRepository.updateSemester(studentId, newSemester);
        logAction("Semester changed for student ID: " + studentId + " to " + newSemester);
        return "Semester updated successfully";
    }

    private void validateStudentInput(StudentDTO studentDTO) {
        // Validation logic
    }

    private void checkDuplicateStudent(StudentDTO studentDTO) {
        // Check for duplicates
    }

    private Long getNextStudentId() {
        // Logic to get next student ID
        return 0L;
    }

    private void validateSubjectsInput(List<SubjectDTO> subjects) {
        // Validation logic
    }

    private void checkDuplicateSubjects(Long studentId, List<SubjectDTO> subjects) {
        // Check for duplicates
    }

    private void validateStudentName(String studentName) {
        // Validation logic
    }

    private void validateSearchParameters(Long studentId, Long courseId, String semester) {
        // Validation logic
    }

    private void validateStudentId(Long studentId) {
        // Validation logic
    }

    private void validateSemester(String semester) {
        // Validation logic
    }

    private void logAction(String message) {
        // Logging logic
    }
}