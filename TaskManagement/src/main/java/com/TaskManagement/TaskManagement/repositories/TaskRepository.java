package com.TaskManagement.TaskManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskManagement.TaskManagement.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
    
}
