package io.github.vfedoriv.javaoutput3.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchServiceTest {

    @Test
    void testClearSearchParams() {
        SearchService searchService = new SearchService();
        SearchParams searchParams = new SearchParams("test", 10, true);
        
        String message = searchService.clearSearchParams(searchParams);
        
        assertEquals("", searchParams.getQuery());
        assertEquals(0, searchParams.getPage());
        assertEquals(false, searchParams.isActive());
        assertEquals("Search parameters cleared", message);
    }
}