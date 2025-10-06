package io.github.vfedoriv.javaoutput3.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ChangeSemesterRequest {
    
    @NotNull
    private Long studentId;

    @NotNull
    @Size(min = 1, max = 50)
    private String newSemester;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getNewSemester() {
        return newSemester;
    }

    public void setNewSemester(String newSemester) {
        this.newSemester = newSemester;
    }
}