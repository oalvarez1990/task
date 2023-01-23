package com.TaskManagement.TaskManagement.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManagement.TaskManagement.models.Activity;
import com.TaskManagement.TaskManagement.repositories.ActivityRepository;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    // Method create activity
    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    // Method find all activity
    public ArrayList<Activity> getActivity() {
        return (ArrayList<Activity>) activityRepository.findAll();
    }

    // Method find activity by id
    public Activity getActivityById(Long id) {
        return activityRepository.findById(id).orElse(null);
    }

    // Method update activity
    public Activity updateActivity(Activity activity) {
        Activity existingActivity = activityRepository.findById(activity.getId()).orElse(null);
        existingActivity.setName(activity.getName());
        existingActivity.setDescription(activity.getDescription());
        existingActivity.setStarDate(activity.getStarDate());
        existingActivity.setFinishDate(activity.getFinishDate());
        return activityRepository.save(existingActivity);
    }

    // Method delete activity
    public boolean deleteActivity(Long id) {
        try {
            activityRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return true;
        }
    }

}
