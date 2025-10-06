package io.github.vfedoriv.javaoutput3.exception;

public class CourseValidationException extends RuntimeException {
    public CourseValidationException() {
        super();
    }

    public CourseValidationException(String message) {
        super(message);
    }

    public CourseValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CourseValidationException(Throwable cause) {
        super(cause);
    }
}