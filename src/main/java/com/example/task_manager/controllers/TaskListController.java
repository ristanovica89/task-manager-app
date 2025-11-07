package com.example.task_manager.controllers;

import com.example.task_manager.entities.TaskList;
import com.example.task_manager.services.TaskListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task-list")
public class TaskListController {

    private final TaskListService taskListService;

    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @GetMapping
    public ResponseEntity<List<TaskList>> getAllTaskListsForAppUserId(){
        var taskListsForAppUser = taskListService.findAllByAppUserId();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskListsForAppUser);
    }

    @GetMapping("{taskListId}")
    public ResponseEntity<TaskList> getTaskListByIdForUser(@PathVariable Integer taskListId){
        var taskList = taskListService.findByTaskListIdForAppUserId(taskListId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskList);
    }

    @PostMapping
    public ResponseEntity<String> createNewTaskList(@RequestBody TaskList taskList){
        String response = taskListService.createNewTaskList(taskList);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @DeleteMapping("{taskListId}")
    public ResponseEntity<String> deleteTaskListById(@PathVariable Integer taskListId){
        String msg = taskListService.deleteByTaskListId(taskListId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(msg);
    }
}
