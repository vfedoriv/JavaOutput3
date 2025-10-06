package io.github.vfedoriv.javaoutput3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface StudentSubjectRepository extends JpaRepository<StudentSubject, Long> {
    
    List<StudentSubject> findByStudentId(Long studentId);
    
    List<StudentSubject> findByCourseId(Long courseId);
    
    @Query("SELECT ss FROM StudentSubject ss WHERE ss.semester = :semester")
    List<StudentSubject> findBySemester(@Param("semester") String semester);
}