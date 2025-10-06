package io.github.vfedoriv.javaoutput3.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SearchParams {
    
    @NotNull
    @Size(min = 1, max = 50)
    private String studentId;

    @NotNull
    @Size(min = 1, max = 50)
    private String studentName;

    @NotNull
    @Size(min = 1, max = 50)
    private String courseId;

    @NotNull
    @Size(min = 1, max = 50)
    private String courseName;

    @NotNull
    @Size(min = 1, max = 10)
    private String semester;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}