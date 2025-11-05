package com.example.task_manager.services;

import com.example.task_manager.entities.TaskList;
import com.example.task_manager.repository.TaskListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListService {
    private final TaskListRepository taskListRepository;
    Integer appUserId = 1; // hard-coded

    public TaskListService(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    public List<TaskList> findAllByAppUserId(){

        return taskListRepository.findAllByAppUser_UserId(appUserId);
    }

    public TaskList findByTaskListIdForAppUserId(Integer taskListId){
        return taskListRepository.findByTaskListIdAndAppUser_UserId(taskListId, appUserId)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

}
