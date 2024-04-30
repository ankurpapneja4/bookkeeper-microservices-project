package com.github.ankurpapneja4.bookkeeper.advice;

import com.github.ankurpapneja4.bookkeeper.exceptions.NotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleException(IllegalArgumentException exp){
        return ResponseEntity.badRequest().body(
                new ErrorMessage(exp.getMessage(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleException(NotFoundException exp){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleException(RuntimeException exp){
        return ResponseEntity.internalServerError().body(
                new ErrorMessage(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleConstraintViolationException(ConstraintViolationException exp){
        return ResponseEntity
                .badRequest()
                .body( exp.getConstraintViolations()
                        .stream()
                        .map( error -> error.toString())
                        .collect(Collectors.toList()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleException(MethodArgumentNotValidException exp){
        return ResponseEntity
                .badRequest()
                .body( exp.getFieldErrors()
                            .stream()
                            .map( error -> error.getField() + " | " + error.getDefaultMessage() )
                            .collect(Collectors.toList()));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ErrorMessage{
        private String error;

        private HttpStatus status;

    }
}

