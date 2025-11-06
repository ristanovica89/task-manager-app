package com.example.task_manager.repository;

import com.example.task_manager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findAllByTaskList_TaskListId(Integer taskListId);
    Optional<Task> findByTaskIdAndTaskList_TaskListId(Integer taskId, Integer taskListId);
}
