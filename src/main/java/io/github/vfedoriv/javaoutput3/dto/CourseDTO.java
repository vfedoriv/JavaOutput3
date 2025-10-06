package io.github.vfedoriv.javaoutput3.dto;

import java.util.List;

public class CourseDTO {
    private String courseName;
    private String semester;
    private List<String> selectedSubjectIds;
    private String id;
    private String name;

    public CourseDTO(String courseName, String semester, List<String> selectedSubjectIds, String id, String name) {
        this.courseName = courseName;
        this.semester = semester;
        this.selectedSubjectIds = selectedSubjectIds;
        this.id = id;
        this.name = name;
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

    public List<String> getSelectedSubjectIds() {
        return selectedSubjectIds;
    }

    public void setSelectedSubjectIds(List<String> selectedSubjectIds) {
        this.selectedSubjectIds = selectedSubjectIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}