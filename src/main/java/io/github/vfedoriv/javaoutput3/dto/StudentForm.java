package io.github.vfedoriv.javaoutput3.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StudentForm {
    
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotNull(message = "Course ID is mandatory")
    private Long courseId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}