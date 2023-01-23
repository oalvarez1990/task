package com.TaskManagement.TaskManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskManagement.TaskManagement.models.Statu;

public interface StatuRepository extends JpaRepository<Statu, Long>{

    Statu findByName(String name);   
    
}
