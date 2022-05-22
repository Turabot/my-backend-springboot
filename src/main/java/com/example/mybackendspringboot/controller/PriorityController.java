package com.example.mybackendspringboot.controller;

import com.example.mybackendspringboot.entity.Priority;
import com.example.mybackendspringboot.repo.PriorityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private final PriorityRepository priorityRepository;

    public PriorityController(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @GetMapping("/all")
    public List<Priority> findAll() {
        return priorityRepository.findAllByOrderByIdAsc();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Priority> findById(@PathVariable Long id) {
        Priority priority = priorityRepository.findById(id).get();
        return null;
    }

    @PostMapping("/add")
    public Priority addPriority(@RequestBody Priority priority) {
        return priorityRepository.save(priority);
    }

    @PutMapping
    public ResponseEntity<Priority> update(@RequestBody Priority priority) {
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {

    }

}
