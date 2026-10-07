package com.ibm.sri.tech.exception;

import com.ibm.sri.tech.model.error.ErrorMessage;
import com.ibm.sri.tech.model.error.ErrorResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Value("${spring.application.name}")
    private String applicationName;

    @ExceptionHandler(SessionException.class)
    public ResponseEntity<ErrorResponse> handleSessionException(SessionException exception) {

        ErrorMessage errorMsg = new ErrorMessage();
        errorMsg.setCode(exception.getCode());
        errorMsg.setMessage(exception.getMessage());
        errorMsg.setOrigmesg(exception.getDetails());
        errorMsg.setTitle(exception.getTitle());
        ErrorResponse errorResponse = getErrorResponse(errorMsg);
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(exception.getHttpCode()));
    }


    private ErrorResponse getErrorResponse(ErrorMessage errorMsg) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError(errorMsg);
        errorResponse.setErrorAt(LocalDateTime.now());
        errorResponse.setErrorId(UUID.randomUUID().toString());
        errorResponse.setErrorLocation(applicationName);
        errorResponse.setErrors(List.of(errorMsg));
        return errorResponse;
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception e) {
//
//    }
}
