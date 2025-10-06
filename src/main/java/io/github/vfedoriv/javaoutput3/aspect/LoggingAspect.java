package io.github.vfedoriv.javaoutput3.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* io.github.vfedoriv.javaoutput3.service.StudentService.addSubjectToStudent(..)) && args(studentId, subjectId)")
    public void logAddSubjectToStudent(JoinPoint joinPoint, Long studentId, Long subjectId) {
        logger.info("Adding subject with ID: {} to student with ID: {}", subjectId, studentId);
    }

    @AfterReturning(pointcut = "execution(* io.github.vfedoriv.javaoutput3.service.StudentService.addSubjectToStudent(..))", returning = "result")
    public void logAddSubjectToStudentResult(JoinPoint joinPoint, Object result) {
        logger.info("Successfully added subject to student. Result: {}", result);
    }

    @Before("execution(* io.github.vfedoriv.javaoutput3.service.SubjectService.deleteSubject(..)) && args(studentId, subjectId)")
    public void logDeleteSubject(JoinPoint joinPoint, Long studentId, Long subjectId) {
        logger.info("Deleting subject with ID: {} for student with ID: {}", subjectId, studentId);
    }
}