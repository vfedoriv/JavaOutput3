package io.github.vfedoriv.javaoutput3.model;

import lombok.Data;

@Data
public class SearchParams {
    private int stuId;
    private String stuName;
    private int courseId;
    private String courseName;
    private String semester;

    public void reset() {
        this.stuId = 0;
        this.stuName = "";
        this.courseId = 0;
        this.courseName = "";
        this.semester = "";
    }
}