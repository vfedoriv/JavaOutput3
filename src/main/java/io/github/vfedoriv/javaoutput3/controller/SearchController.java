package io.github.vfedoriv.javaoutput3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.vfedoriv.javaoutput3.service.SearchService;
import io.github.vfedoriv.javaoutput3.model.SearchParams;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/clear")
    public ResponseEntity<?> clearSearch() {
        SearchParams searchParams = new SearchParams();
        searchParams.setStuId(0);
        searchParams.setStuName("");
        searchParams.setCourseId(0);
        searchParams.setCourseName("");
        searchParams.setSemester("");
        return ResponseEntity.ok("Search parameters cleared successfully.");
    }

    @GetMapping("/reloadSearchResult")
    public ResponseEntity<?> reloadSearchResult(@RequestParam SearchParams searchParams) {
        if (searchParams == null || (searchParams.getStuId() == 0 && searchParams.getStuName().isEmpty() &&
            searchParams.getCourseId() == 0 && searchParams.getCourseName().isEmpty() && searchParams.getSemester().isEmpty())) {
            return ResponseEntity.badRequest().body("No search criteria provided.");
        }
        var results = searchService.performSearch(searchParams);
        return ResponseEntity.ok(results);
    }
}