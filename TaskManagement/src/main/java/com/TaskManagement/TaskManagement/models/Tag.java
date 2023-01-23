package com.TaskManagement.TaskManagement.models;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;


@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

     // relation manytoMany with task
     @ManyToMany
     @JoinTable(name = "task_tag",
         joinColumns = @JoinColumn(name = "tag_id"),
         inverseJoinColumns = @JoinColumn(name = "task_id")
     )
     private List<Task> tasks;
    
    // Define attributes for the entity status
    private String name;
    private String color;

    // Define the constructor empty
    public Tag() {
    }

    // Define the constructor
    public Tag(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // Define the getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Define the toString method
    @Override
    public String toString() {
        return "Tag [color=" + color + ", name=" + name + "]";
    }


}
