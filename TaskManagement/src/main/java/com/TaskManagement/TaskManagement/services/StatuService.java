package com.TaskManagement.TaskManagement.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManagement.TaskManagement.models.Statu;

import com.TaskManagement.TaskManagement.repositories.StatuRepository;

@Service
public class StatuService {
    @Autowired
    private StatuRepository statuRepository;


    // Method create statu
    public Statu createStatu(Statu statu){
        return statuRepository.save(statu);
    }

    // Method find all statu
    public ArrayList<Statu> getStatu(){
        return (ArrayList<Statu>)statuRepository.findAll();
    }

    // Method find statu by id
    public Statu getStatuById(Long id){
        return statuRepository.findById(id).orElse(null);
    }
    
}
