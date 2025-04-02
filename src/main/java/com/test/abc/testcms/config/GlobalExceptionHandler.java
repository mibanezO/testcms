package com.test.abc.testcms.config;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", e.getMessage());
        map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        map.put("timestamp", System.currentTimeMillis());
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>>
    handleConstraintViolationException(ConstraintViolationException ex){
        List<String> details =
                ex.getConstraintViolations().stream()
                        .map(e -> String.format("%s: %s", e.getPropertyPath(), e.getMessage()))
                        .toList();
        Map<String, Object> map = new HashMap<>();
        map.put("message", details);
        map.put("status", HttpStatus.BAD_REQUEST.value());
        map.put("timestamp", System.currentTimeMillis());
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>>
    handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, Object> map = new HashMap<>();
        String message = Optional.ofNullable(ex.getBindingResult().getFieldError())
                .map(fieldError -> String.format("%s: %s", fieldError.getField(), fieldError.getDefaultMessage()))
                .orElse(ex.getMessage());
        map.put("message", message);
        map.put("status", HttpStatus.BAD_REQUEST.value());
        map.put("timestamp", System.currentTimeMillis());
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

}
