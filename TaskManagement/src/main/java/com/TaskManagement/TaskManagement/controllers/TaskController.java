package com.TaskManagement.TaskManagement.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TaskManagement.TaskManagement.models.Task;
import com.TaskManagement.TaskManagement.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    // Get all task
    @GetMapping()
    public ArrayList<Task> getTask() {
        return taskService.getTask();
    }

    // Create task
    @PostMapping()
    public Task createTask(@RequestBody Task task) {
        return this.taskService.createTask(task);
    }

    // Delete task
    @DeleteMapping(path = "/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        boolean ok = this.taskService.deleteTask(id);
        if (ok) {
            return "The task with id has been deleted " + id;
        } else {
            return "Could not delete task with id" + id;
        }
    }

}
