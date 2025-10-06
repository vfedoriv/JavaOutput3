package io.github.vfedoriv.javaoutput3.service;

import io.github.vfedoriv.javaoutput3.exception.CourseNotFoundException;
import io.github.vfedoriv.javaoutput3.exception.CourseValidationException;
import io.github.vfedoriv.javaoutput3.repository.CourseRepository;
import io.github.vfedoriv.javaoutput3.repository.StudentRepository;
import io.github.vfedoriv.javaoutput3.dto.CourseDTO;
import io.github.vfedoriv.javaoutput3.entity.Course;
import io.github.vfedoriv.javaoutput3.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private static final int RECORD_COUNT = 100;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public CourseDTO addCourse(CourseDTO courseDTO) {
        validateCourse(courseDTO);
        Course course = new Course(courseDTO.getName(), courseDTO.getSemester());
        return mapToDTO(courseRepository.save(course));
    }

    public boolean checkExistingCourse(String courseName) {
        return courseRepository.existsByName(courseName);
    }

    @Transactional
    public CourseDTO addOrUpdate(CourseDTO courseDTO) {
        if (courseDTO.getId() != null && courseRepository.existsById(courseDTO.getId())) {
            return updateCourse(courseDTO);
        } else {
            return addCourse(courseDTO);
        }
    }

    public List<CourseDTO> loadCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(this::mapToDTO).toList();
    }

    public List<Student> searchByCourseId(Integer courseId) {
        if (courseId == null || courseId < 0) {
            throw new CourseValidationException("Invalid course ID");
        }
        if (!doesCourseExist(courseId)) {
            throw new CourseNotFoundException("Course not found");
        }
        return studentRepository.findByCourseId(courseId);
    }

    public List<Student> searchByCourseName(String courseName) {
        Integer courseId = getCourseId(courseName);
        if (courseId == null) {
            throw new CourseNotFoundException("Course not found");
        }
        List<Student> students = studentRepository.findByCourseId(courseId);
        if (students.isEmpty()) {
            throw new CourseNotFoundException("No students found for the course");
        }
        return students;
    }

    private void validateCourse(CourseDTO courseDTO) {
        if (courseDTO.getName() == null || courseDTO.getName().isEmpty()) {
            throw new CourseValidationException("Course name cannot be empty");
        }
        if (!courseRepository.existsBySemester(courseDTO.getSemester())) {
            throw new CourseValidationException("Semester does not exist");
        }
    }

    private boolean doesCourseExist(Integer courseId) {
        return courseRepository.existsById(courseId);
    }

    private Integer getCourseId(String courseName) {
        return courseRepository.findIdByName(courseName);
    }

    private CourseDTO mapToDTO(Course course) {
        return new CourseDTO(course.getId(), course.getName());
    }

    private CourseDTO updateCourse(CourseDTO courseDTO) {
        Course course = courseRepository.findById(courseDTO.getId()).orElseThrow(() -> new CourseValidationException("Course not found"));
        course.setName(courseDTO.getName());
        course.setSemester(courseDTO.getSemester());
        return mapToDTO(courseRepository.save(course));
    }
}