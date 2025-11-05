package com.example.task_manager.controllers;

import com.example.task_manager.entities.Task;
import com.example.task_manager.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task-list/{taskListId}/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasksOfTaskList(@PathVariable Integer taskListId){
        var tasks = taskService.getAllTasksForTaskListId(taskListId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tasks);
    }
}
