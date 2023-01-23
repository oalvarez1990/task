package com.TaskManagement.TaskManagement.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    // relation manytoOne wiht task
     @ManyToOne
    private Task task;       
    
    // Define attributes for the entity status
    private String name;
    private String description;
    private Date starDate;
    private Date finishDate;

    // Define the constructor empty
    public Activity() {
    }
    // Define the constructor
    public Activity(String name, String description, Date starDate, Date finishDate) {
        this.name = name;
        this.description = description;
        this.starDate = starDate;
        this.finishDate = finishDate;
    }

    // Define the getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStarDate() {
        return starDate;
    }
    
    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    // Define the toString method
    @Override
    public String toString() {
        return "Activity [description=" + description + ", finishDate=" + finishDate + ", name=" + name + ", starDate="
                + starDate + "]";
    }
    public Long getId() {
        return null;
    }

}
