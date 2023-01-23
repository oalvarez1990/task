package com.TaskManagement.TaskManagement.controllers;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.TaskManagement.TaskManagement.models.User;
import com.TaskManagement.TaskManagement.services.UserService;

import jakarta.validation.Valid;

import com.TaskManagement.TaskManagement.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    //Get all user
    @GetMapping()
    public ArrayList<User> getUser() {
        return userService.getUser();
    }

    //Create user
    @PostMapping()
    public User createUser(@Valid @RequestBody User user) {
        // Validate if the user already exists
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "User with email " + user.getEmail() + " already exists.");
        }
        return this.userService.createUser(user);       

    }

    // delete user
    @DeleteMapping( path = "/{id}")
    public String deleteUserId(@PathVariable(value = "id") Long id) {
        boolean ok = this.userService.deleteUserId(id);
        if (ok) {
            return "The user with id will be deleted " + id;
        } else {
            return "Could not delete user with id " + id;
        }
    }

    // search user for id and validate 
    @GetMapping( path = "/{Id}")
    public Optional<User> searchUserId(@PathVariable(value = "id") Long id) {
        return this.userService.searchUserId(id);        
    }

    // update user
    @PostMapping( path = "/{id}")
    public User updateUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

}
