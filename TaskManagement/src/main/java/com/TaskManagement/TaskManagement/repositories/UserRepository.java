package com.TaskManagement.TaskManagement.repositories;

import org.springframework.stereotype.Repository;

import com.TaskManagement.TaskManagement.models.User;



import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    // validate users exists
    public User findByEmail(String email);   

}
