package com.example.mybackendspringboot.controller;

import com.example.mybackendspringboot.entity.Priority;
import com.example.mybackendspringboot.repo.PriorityRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private final PriorityRepository priorityRepository;

    public PriorityController(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @PostMapping("/add")
    public Priority addPriority(@RequestBody Priority priority) {
        return priorityRepository.save(priority);
    }

}
