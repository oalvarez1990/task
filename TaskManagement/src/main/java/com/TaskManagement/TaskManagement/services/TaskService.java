package com.TaskManagement.TaskManagement.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManagement.TaskManagement.models.Task;
import com.TaskManagement.TaskManagement.repositories.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    

     // Method create task
        public Task createTask(Task task){
            return taskRepository.save(task);
        }
        // Method find all task
        public ArrayList<Task> getTask(){
            return (ArrayList<Task>)taskRepository.findAll();
        }

        // Method delete task
        public boolean deleteTask(Long id){
            try{
                taskRepository.deleteById(id);
                return true;
            }catch(Exception err){
                return true;
            }
        }

        
    
}
