package com.example.mybackendspringboot.controller;

import com.example.mybackendspringboot.dto.PriorityDto;
import com.example.mybackendspringboot.entity.Priority;
import com.example.mybackendspringboot.service.PriorityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
@CrossOrigin(origins = "http://localhost:4200")
public class PriorityController {

    private final PriorityService priorityService;

    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @GetMapping("/all")
    public List<Priority> findAll() {
        return priorityService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Priority> add(@RequestBody PriorityDto priorityDto) {
        return ResponseEntity.ok(priorityService.add(priorityDto));
    }

    @PutMapping("/update")
    public void update(@RequestBody PriorityDto priorityDto) {
        priorityService.update(priorityDto);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Priority> findById(@PathVariable Long id) {
        Priority priority = priorityService.findById(id);

        return ResponseEntity.ok(priority);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        priorityService.deleteById(id);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Priority>> search(@RequestBody PriorityDto priorityDto) {

        return ResponseEntity.ok(priorityService.findByTitle(priorityDto.getTitle()));
    }
}
