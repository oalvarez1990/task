package com.TaskManagement.TaskManagement.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class Statu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    // relation manytoOne wiht task
    @ManyToOne
    private Task task;

    // Define attributes for the entity status
    private String name;

    // Define the constructor empty
    public Statu() {
    }

    // Define the constructor
    public Statu(String name) {
        this.name = name;
    }

    // Define the getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Define the toString method

}
