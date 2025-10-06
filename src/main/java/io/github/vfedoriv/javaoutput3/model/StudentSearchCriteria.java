package io.github.vfedoriv.javaoutput3.model;

import java.util.Objects;

public class StudentSearchCriteria {
    private String id;
    private String name;
    private String courseId;
    private String courseName;
    private String semester;

    public StudentSearchCriteria(String id, String name, String courseId, String courseName, String semester) {
        this.id = id;
        this.name = name;
        this.courseId = courseId;
        this.courseName = courseName;
        this.semester = semester;
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

    public boolean isValid() {
        return (id != null && !id.isEmpty()) || 
               (name != null && !name.isEmpty()) || 
               (courseId != null && !courseId.isEmpty()) || 
               (courseName != null && !courseName.isEmpty()) || 
               (semester != null && !semester.isEmpty());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentSearchCriteria)) return false;
        StudentSearchCriteria that = (StudentSearchCriteria) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(name, that.name) &&
               Objects.equals(courseId, that.courseId) &&
               Objects.equals(courseName, that.courseName) &&
               Objects.equals(semester, that.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, courseId, courseName, semester);
    }

    @Override
    public String toString() {
        return "StudentSearchCriteria{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", courseId='" + courseId + '\'' +
               ", courseName='" + courseName + '\'' +
               ", semester='" + semester + '\'' +
               '}';
    }
}