package io.github.vfedoriv.javaoutput3.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentSubjectDTO {
    
    @NotNull
    private Long studentId;

    @NotNull
    private Long subjectId;

    @Size(max = 255)
    private String additionalData;

    public StudentSubjectDTO() {
    }

    public StudentSubjectDTO(Long studentId, Long subjectId, String additionalData) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.additionalData = additionalData;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }
}