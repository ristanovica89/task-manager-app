package com.example.task_manager.repository;

import com.example.task_manager.entities.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskListRepository extends JpaRepository<TaskList, Integer> {

    List<TaskList> findAllByAppUser_UserId(Integer userId);
    Optional<TaskList> findByTaskListIdAndAppUser_UserId(Integer taskListId, Integer userId);
}
