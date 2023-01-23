package com.TaskManagement.TaskManagement.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.TaskManagement.TaskManagement.models.Statu;
import com.TaskManagement.TaskManagement.repositories.StatuRepository;
import com.TaskManagement.TaskManagement.services.StatuService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/statu")
public class StatuController {
    @Autowired
    StatuService statuService;
    @Autowired
    private StatuRepository statuRepository;

    // Create statu
    @PostMapping()
    public Statu createStatu(@Valid @RequestBody Statu statu) {
        //
        return this.statuService.createStatu(statu);
    }

    // Get all statu
    @GetMapping()
    public ArrayList<Statu> getStatu() {
        return statuService.getStatu();
    }

    // Get statu by id
    @GetMapping("/{id}")
    public Statu getStatuById(@PathVariable(value = "id") Long statuId) {
        return statuRepository.findById(statuId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Statu not found"));
    }

}
