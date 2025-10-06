package io.github.vfedoriv.javaoutput3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SearchRepository extends JpaRepository<SearchResult, Long> {
    List<SearchResult> findByStudentId(Long studentId);
    List<SearchResult> findByStudentName(String studentName);
    List<SearchResult> findByCourseId(Long courseId);
    List<SearchResult> findByCourseName(String courseName);
    List<SearchResult> findBySemester(String semester);
}