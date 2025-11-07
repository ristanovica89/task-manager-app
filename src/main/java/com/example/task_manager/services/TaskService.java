package com.example.task_manager.services;

import com.example.task_manager.entities.Task;
import com.example.task_manager.entities.TaskList;
import com.example.task_manager.repository.TaskListRepository;
import com.example.task_manager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    public TaskService(TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    public List<Task> getAllTasksForTaskListId(Integer taskListId){
        return taskRepository.findAllByTaskList_TaskListId(taskListId);
    }

    public Task getTaskByTaskIdForTaskListId(Integer taskId, Integer taskListId){
        return taskRepository.findByTaskIdAndTaskList_TaskListId(taskId,taskListId)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public String createNewTaskForTaskListId(Task task, Integer taskListId){
        TaskList taskList = taskListRepository.findById(taskListId)
                .orElseThrow(() -> new RuntimeException("Task list not found."));
        task.setTaskList(taskList);
        taskRepository.save(task);
        return "New task has been successfully created";
    }

    public String updateTaskById(Integer taskListId, Integer taskId, Task task){
        TaskList taskList = taskListRepository.findById(taskListId)
                .orElseThrow(() -> new RuntimeException("Task list not found."));
        Task existingTask = taskRepository.findByTaskIdAndTaskList_TaskListId(taskId,taskListId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existingTask.setTitle(task.getTitle());
        existingTask.setShortDescription(task.getShortDescription());
        existingTask.setIsDone(task.getIsDone());

        taskRepository.save(existingTask);

        return "Task with id: " + existingTask.getTaskId() +" has been successfully updated";
    }

    public String deleteById(Integer taskId){
        taskRepository.deleteById(taskId);
        return "Task has been successfully deleted";
    }
}
