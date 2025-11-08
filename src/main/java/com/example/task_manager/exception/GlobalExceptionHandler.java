package com.example.task_manager.exception;

import com.example.task_manager.exception.notFoundExc.TaskListNotFoundException;
import com.example.task_manager.exception.notFoundExc.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = { TaskNotFoundException.class })
    public ResponseEntity<Object> handleTaskNotFoundException(TaskNotFoundException ex) {
        TaskException response = new TaskException(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { TaskListNotFoundException.class })
    public ResponseEntity<Object> handleTaskListNotFoundException(TaskListNotFoundException ex) {
        TaskListException response = new TaskListException(
                ex.getMessage(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
