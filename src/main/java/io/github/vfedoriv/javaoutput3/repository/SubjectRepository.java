package io.github.vfedoriv.javaoutput3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    Subject findByName(String name);
    boolean existsByName(String name);
    List<Subject> findAll(Pageable pageable);
    boolean existsById(Long id);
    Subject findByStudentIdAndSubjectId(Long studentId, Long subjectId);
    List<Subject> findByCourseIdAndSemesterId(Long courseId, Long semesterId);
}