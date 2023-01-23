package com.TaskManagement.TaskManagement.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManagement.TaskManagement.models.Tag;
import com.TaskManagement.TaskManagement.repositories.TagRepository;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    // Method create tag
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    // Method find all tag
    public ArrayList<Tag> getTag() {
        return (ArrayList<Tag>) tagRepository.findAll();
    }

    // Delete task
    public boolean deleteTag(Long id) {
        try {
            tagRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
