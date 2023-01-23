package com.TaskManagement.TaskManagement.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.TaskManagement.TaskManagement.models.User;
import com.TaskManagement.TaskManagement.repositories.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Method find all user
    public ArrayList<User> getUser(){
        return (ArrayList<User>)userRepository.findAll();
    }

    // Method create user
    public User createUser(User user){
        return userRepository.save(user);
    }

    // Method delete user
    public boolean deleteUserId(Long id){
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Method search user for id    
    public Optional<User> searchUserId(Long id){
        return userRepository.findById(id);        
    }

    // Method update user
    public User updateUser(User user){
        return userRepository.save(user);
    }

    

    
}
