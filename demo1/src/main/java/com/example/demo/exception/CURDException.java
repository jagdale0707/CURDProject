package com.example.demo.exception;

import com.example.demo.response.CURDErrorResponse;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CURDException {
    @ExceptionHandler(value = CURDResourceNotFound.class)
    public ResponseEntity<CURDErrorResponse> handleResourceNotFound(CURDResourceNotFound ex, HttpRequest request) {
        CURDErrorResponse errorResponse = new CURDErrorResponse(
                404L,
                HttpStatus.NOT_FOUND.toString(),
                ex.getMessage(),
                request.getURI().getPath(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
