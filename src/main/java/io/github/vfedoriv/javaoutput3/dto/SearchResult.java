package io.github.vfedoriv.javaoutput3.dto;

public class SearchResult {
    private String studentName;
    private String courseName;
    private String semester;

    public SearchResult(String studentName, String courseName, String semester) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.semester = semester;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getSemester() {
        return semester;
    }
}