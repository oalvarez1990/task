package com.TaskManagement.TaskManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskManagement.TaskManagement.models.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    
    
}
