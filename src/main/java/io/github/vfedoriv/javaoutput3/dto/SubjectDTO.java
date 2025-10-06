package io.github.vfedoriv.javaoutput3.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SubjectDTO {
    
    @NotNull
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    private Integer marks;

    public SubjectDTO(Long id, String name, Integer marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMarks() {
        return marks;
    }
}