package com.example.task_manager.exception;

import org.springframework.http.HttpStatus;

public class TaskListException extends BaseException{
    public TaskListException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
