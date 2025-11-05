package com.example.task_manager.services;

import com.example.task_manager.entities.Task;
import com.example.task_manager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasksForTaskListId(Integer taskListId){
        return taskRepository.findAllByTaskList_TaskListId(taskListId);
    }
}
