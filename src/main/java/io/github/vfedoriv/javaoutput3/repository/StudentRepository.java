package io.github.vfedoriv.javaoutput3.repository;

import io.github.vfedoriv.javaoutput3.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findById(Long studentId);
    
    List<Student> findByNameIgnoreCase(String studentName);
    
    List<Student> findByCourseId(Integer courseId);
    
    List<Student> findBySemesterId(Long semesterId);
    
    Optional<Student> findByStudentIdAndCourseIdAndSemester(Long studentId, Long courseId, String semester);
    
    List<Student> findByNameIgnoreCaseAndCourseIdAndSemester(String name, Integer courseId, String semester);
    
    boolean existsById(Long studentId);
}