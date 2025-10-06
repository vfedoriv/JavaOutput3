package io.github.vfedoriv.javaoutput3.service.impl;

import io.github.vfedoriv.javaoutput3.repository.SearchRepository;
import io.github.vfedoriv.javaoutput3.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    private static final Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

    private final SearchRepository searchRepository;

    @Autowired
    public SearchServiceImpl(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Override
    public List<Object> search(String searchType, String searchValue) {
        List<Object> results = null;
        try {
            switch (searchType) {
                case "studentId":
                    results = searchRepository.findByStudentId(searchValue);
                    break;
                case "name":
                    results = searchRepository.findByName(searchValue);
                    break;
                case "courseId":
                    results = searchRepository.findByCourseId(searchValue);
                    break;
                default:
                    logger.warn("Invalid search type: {}", searchType);
                    break;
            }
            logger.info("Search performed with type: {} and value: {}", searchType, searchValue);
        } catch (Exception e) {
            logger.error("Error occurred during search: {}", e.getMessage());
        }
        return results;
    }
}