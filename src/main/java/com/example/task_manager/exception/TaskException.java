package com.example.task_manager.exception;

import org.springframework.http.HttpStatus;

public class TaskException extends BaseException{
    public TaskException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
