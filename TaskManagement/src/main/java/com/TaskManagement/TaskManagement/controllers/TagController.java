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

import com.TaskManagement.TaskManagement.models.Tag;
import com.TaskManagement.TaskManagement.services.TagService;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    // Get all tag
    @GetMapping()
    public ArrayList<Tag> getTag() {
        return tagService.getTag();
    }

    // Create tag
    @PostMapping()
    public Tag createTag(@RequestBody Tag tag) {
        return this.tagService.createTag(tag);
    }

    // Delete tag
    @DeleteMapping(path = "/{id}")
    public String deleteTag(@PathVariable("id") Long id) {
        boolean ok = this.tagService.deleteTag(id);
        if (ok) {
            return "The tag with id has been deleted " + id;
        } else {
            return "Could not delete tag with id " + id;
        }
    }


    
    
}
