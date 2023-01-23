package com.TaskManagement.TaskManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskManagement.TaskManagement.models.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
    
}
