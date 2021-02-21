package com.ourkart.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private static final long serialVersionUID = 1L;
    private String errorMessage;
    private String errorCode;
    private String httpstatusCode;
    private LocalDateTime timestamp;


    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getHttpstatusCode() {
        return httpstatusCode;
    }
    public void setHttpstatusCode(String httpstatusCode) {
        this.httpstatusCode = httpstatusCode;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
