package com.example.task_manager.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class BaseException{

    private final String message;
    private final HttpStatus httpStatus;
}
