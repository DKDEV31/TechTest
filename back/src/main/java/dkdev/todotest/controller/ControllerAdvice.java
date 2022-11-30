package dkdev.todotest.controller;

import dkdev.todotest.DTO.ErrorDTO;
import dkdev.todotest.Exception.DAOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(DAOException.class)
    public ResponseEntity<ErrorDTO> handleDAOException(DAOException e) {
        return ResponseEntity.badRequest().body(new ErrorDTO(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception e) {
        return ResponseEntity.internalServerError().body(new ErrorDTO(e.getMessage()));
    }
}
