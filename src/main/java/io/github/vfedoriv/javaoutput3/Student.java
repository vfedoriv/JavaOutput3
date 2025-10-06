package io.github.vfedoriv.javaoutput3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Student {

    @Id
    @Column(unique = true, nullable = false)
    @NotNull
    private String id;

    @Column(nullable = false)
    @NotNull
    @Size(max = 50)
    private String name;

    @Column(nullable = false)
    @NotNull
    @Pattern(regexp = "[A-F]", message = "Grade must be between A and F")
    private String grade;

    @Column(nullable = false)
    @NotNull
    private String attendance;

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
}