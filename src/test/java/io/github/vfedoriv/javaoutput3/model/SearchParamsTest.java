package io.github.vfedoriv.javaoutput3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchParamsTest {

    private SearchParams searchParams;

    @BeforeEach
    void setUp() {
        searchParams = new SearchParams();
    }

    @Test
    void testReset() {
        searchParams.setSomeField("test");
        searchParams.setAnotherField(5);
        searchParams.setYetAnotherField(true);
        searchParams.reset();
        assertEquals("default", searchParams.getSomeField());
        assertEquals(0, searchParams.getAnotherField());
        assertEquals(false, searchParams.isYetAnotherField());
    }

    @Test
    void testGettersAfterReset() {
        searchParams.reset();
        assertEquals("default", searchParams.getSomeField());
        assertEquals(0, searchParams.getAnotherField());
        assertEquals(false, searchParams.isYetAnotherField());
    }
}