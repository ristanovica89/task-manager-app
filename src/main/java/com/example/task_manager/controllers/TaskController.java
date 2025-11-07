package com.example.task_manager.controllers;

import com.example.task_manager.entities.Task;
import com.example.task_manager.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer taskListId,
                                            @PathVariable Integer taskId){
        var task = taskService.getTaskByTaskIdForTaskListId(taskId,taskListId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(task);
    }

    @PostMapping
    public ResponseEntity<String> createNewTask(@PathVariable Integer taskListId,
                                                @RequestBody Task task){
        String response = taskService.createNewTaskForTaskListId(task,taskListId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("{taskId}")
    public ResponseEntity<String> updateById(@PathVariable Integer taskListId,
                                             @PathVariable Integer taskId,
                                             @RequestBody Task task){
        String response = taskService.updateTaskById(taskListId, taskId, task);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @DeleteMapping("{taskId}")
    public ResponseEntity<String> deleteById(@PathVariable Integer taskId){
        String response = taskService.deleteById(taskId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
