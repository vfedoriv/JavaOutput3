package io.github.vfedoriv.javaoutput3.response;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String status;
    private String message;
    private String error;
    private LocalDateTime timestamp;
    private String errorCode;

    public ErrorResponse(String status, String message, String error, LocalDateTime timestamp, String errorCode) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.timestamp = timestamp;
        this.errorCode = errorCode;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getErrorCode() {
        return errorCode;
    }
}