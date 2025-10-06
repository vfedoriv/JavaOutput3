package io.github.vfedoriv.javaoutput3.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import io.github.vfedoriv.javaoutput3.service.StudentSubjectOptionsService;

public class StudentSubjectOptionsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private StudentSubjectOptionsService studentSubjectOptionsService;

    @InjectMocks
    private StudentSubjectOptionsController studentSubjectOptionsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentSubjectOptionsController).build();
    }

    @Test
    public void testGetAllOptions() throws Exception {
        when(studentSubjectOptionsService.getAllOptions()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/api/student-subject-options")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetOptionById() throws Exception {
        when(studentSubjectOptionsService.getOptionById(1L)).thenReturn(new StudentSubjectOption());

        mockMvc.perform(get("/api/student-subject-options/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateOption() throws Exception {
        StudentSubjectOption option = new StudentSubjectOption();
        when(studentSubjectOptionsService.createOption(any(StudentSubjectOption.class))).thenReturn(option);

        mockMvc.perform(post("/api/student-subject-options")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Option1\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateOption() throws Exception {
        StudentSubjectOption option = new StudentSubjectOption();
        when(studentSubjectOptionsService.updateOption(eq(1L), any(StudentSubjectOption.class))).thenReturn(option);

        mockMvc.perform(put("/api/student-subject-options/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"UpdatedOption\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteOption() throws Exception {
        doNothing().when(studentSubjectOptionsService).deleteOption(1L);

        mockMvc.perform(delete("/api/student-subject-options/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testHandleNotFound() throws Exception {
        when(studentSubjectOptionsService.getOptionById(1L)).thenThrow(new ResourceNotFoundException());

        mockMvc.perform(get("/api/student-subject-options/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}