package com.project_Test.Exceptions;

import com.project_Test.Exceptions.messages.ApiErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorMessage> resourceNotFoundExceptionHandler(ResourceNotFoundException e, HttpServletRequest request) {
        ApiErrorMessage resultMessange = new ApiErrorMessage();
        resultMessange.setStatus(HttpStatus.NOT_FOUND.value());
        resultMessange.setTimestamp(Instant.now());
        resultMessange.setError("Recurso não encontrado");
        resultMessange.setMessagem(e.getMessage());
        resultMessange.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(resultMessange);
    }
}

