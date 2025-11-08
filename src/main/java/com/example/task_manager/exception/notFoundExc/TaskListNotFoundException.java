package com.example.task_manager.exception.notFoundExc;

public class TaskListNotFoundException extends RuntimeException{
    public TaskListNotFoundException(String message) {
        super(message);
    }
}
