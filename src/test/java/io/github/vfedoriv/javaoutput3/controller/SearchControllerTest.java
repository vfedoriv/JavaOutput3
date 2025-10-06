package io.github.vfedoriv.javaoutput3.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SearchController.class)
public class SearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testClearSearchParams() throws Exception {
        mockMvc.perform(post("/clearSearchParams"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Search parameters cleared"))
                .andExpect(jsonPath("$.searchParams").value("default values"));
    }
}