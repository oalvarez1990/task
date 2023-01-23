package com.TaskManagement.TaskManagement.models;

import java.util.List;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    // relation onetomany wiht task
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Task> tasks;

    // Define attributes for the entity
    @NotBlank(message = "Name is required")
    private String firtsName;    
    private String secondName;
    @NotBlank(message = "firtsSurName is required")
    private String firtsSurName;   
    private String secondSurName;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    @Min(value=7, message="Phone number must be between 7 and 10 digits")
    private String phone;
   

    // Define the constructor empty
    public User() {
    }

    // Define the constructor
    public User(String firtsName, String secondName, String firtsSurName, String secondSurName, String email,
        String password, String phone) {
        this.firtsName = firtsName;
        this.secondName = secondName;
        this.firtsSurName = firtsSurName;
        this.secondSurName = secondSurName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    // Define the getters and setters
    public String getFirtsName() {
        return firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirtsSurName() {
        return firtsSurName;
    }

    public void setFirtsSurName(String firtsSurName) {
        this.firtsSurName = firtsSurName;
    }

    public String getSecondSurName() {
        return secondSurName;
    }

    public void setSecondSurName(String secondSurName) {
        this.secondSurName = secondSurName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Define the toString method
    @Override
    public String toString() {
        return "User{" + "firtsName=" + firtsName + ", secondName=" + secondName + ", firtsSurName=" + firtsSurName
                + ", secondSurName=" + secondSurName + ", email=" + email + ", password=" + password + ", phone="
                + phone + '}';
    }

}
