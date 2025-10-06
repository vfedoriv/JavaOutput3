package io.github.vfedoriv.javaoutput3.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class SubjectRequest {
    @NotBlank
    private String subjectName;
}