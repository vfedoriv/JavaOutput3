package io.github.vfedoriv.javaoutput3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SemesterRepository semesterRepository;

    @Autowired
    private SubjectEnrollmentRepository subjectEnrollmentRepository;

    public String addSubject(SubjectDTO subjectDTO) {
        if (subjectDTO.getName() == null || subjectDTO.getName().isEmpty()) {
            throw new CustomException("Subject name cannot be empty");
        }
        if (subjectRepository.existsByName(subjectDTO.getName())) {
            throw new CustomException("Subject already exists");
        }
        Long newId = subjectRepository.findMaxId().map(id -> id + 10).orElse(10L);
        Subject subject = new Subject(newId, subjectDTO.getName());
        subjectRepository.save(subject);
        return "Subject added successfully";
    }

    public List<SubjectDTO> loadSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream().map(subject -> new SubjectDTO(subject.getId(), subject.getName())).toList();
    }

    public void addSubjectToStudent(int studentId, int subjectId, int semesterId, int marks) {
        if (!studentRepository.existsById(studentId)) {
            throw new CustomException("Student not found");
        }
        if (!subjectRepository.existsById(subjectId)) {
            throw new CustomException("Subject not found");
        }
        if (!semesterRepository.existsById(semesterId)) {
            throw new CustomException("Semester not found");
        }
        if (subjectEnrollmentRepository.existsByStudentIdAndSubjectId(studentId, subjectId)) {
            throw new CustomException("Subject already enrolled for this student");
        }
        SubjectEnrollment enrollment = new SubjectEnrollment(studentId, subjectId, semesterId, marks);
        subjectEnrollmentRepository.save(enrollment);
    }

    public void deleteSubject(Long studentId, Long subjectId) {
        if (!studentRepository.existsById(studentId)) {
            throw new CustomException("Student not found");
        }
        if (!subjectEnrollmentRepository.existsByStudentIdAndSubjectId(studentId, subjectId)) {
            throw new CustomException("Subject not found for this student");
        }
        subjectEnrollmentRepository.deleteByStudentIdAndSubjectId(studentId, subjectId);
    }

    public List<Subject> getAvailableSubjects(Long currentCourseId, Long avaSemId) {
        if (!courseRepository.existsById(currentCourseId) || !semesterRepository.existsById(avaSemId)) {
            throw new SubjectNotFoundException("Invalid course or semester ID");
        }
        return subjectRepository.findByCourseIdAndSemesterId(currentCourseId, avaSemId);
    }
}