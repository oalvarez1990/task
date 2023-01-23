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

import com.TaskManagement.TaskManagement.models.Activity;
import com.TaskManagement.TaskManagement.services.ActivityService;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    // Method create activity
    @PostMapping()
    public Activity createActivity(@RequestBody Activity activity){
        return activityService.createActivity(activity);
    }

    // Method find all activity
    @GetMapping()
    public ArrayList<Activity> getActivity(){
        return activityService.getActivity();
    }

    // Method find activity by id
    @GetMapping("/{id}")
    public Activity getActivityById(Long id){
        return activityService.getActivityById(id);
    }
    
    // Method delete activity by id
    @DeleteMapping(path = "/{id}")
    public boolean deleteActivity(@PathVariable("id") Long id) {
        boolean ok = this.activityService.deleteActivity(id);
        if (ok) {
            return true;
        } else {
            return false;
        }

    }


    

}
