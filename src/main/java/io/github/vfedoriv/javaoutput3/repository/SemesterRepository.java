package io.github.vfedoriv.javaoutput3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, String> {
    boolean existsByName(String semesterName);
}