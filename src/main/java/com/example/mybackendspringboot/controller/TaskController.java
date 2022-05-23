package com.example.mybackendspringboot.controller;

import com.example.mybackendspringboot.dto.TaskRequestDto;
import com.example.mybackendspringboot.entity.Task;
import com.example.mybackendspringboot.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Task> add(@RequestBody TaskRequestDto taskRequestDto) {
        return ResponseEntity.ok(taskService.add(taskRequestDto));
    }

    @PutMapping("/update")
    public void update(@RequestBody TaskRequestDto taskRequestDto) {
        taskService.update(taskRequestDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteById(id);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Task task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Task>> search(@RequestBody TaskRequestDto taskRequestDto) {

        String text = taskRequestDto.getTitle() != null ? taskRequestDto.getTitle() : null;

        Integer completed = taskRequestDto.getCompleted() != null ? taskRequestDto.getCompleted() : null;

        Long priorityId = taskRequestDto.getPriorityId() != null ? taskRequestDto.getPriorityId() : null;
        Long categoryId = taskRequestDto.getCategoryId() != null ? taskRequestDto.getCategoryId() : null;

        String sortColumn = taskRequestDto.getSortColumn() != null ? taskRequestDto.getSortColumn() : null;
        String sortDirection = taskRequestDto.getSortDirection() != null ? taskRequestDto.getSortDirection() : null;

        Integer pageNumber = taskRequestDto.getPageNumber() != null ? taskRequestDto.getPageNumber() : null;
        Integer pageSize = taskRequestDto.getPageSize() != null ? taskRequestDto.getPageSize() : null;

        Sort.Direction direction = sortDirection == null || sortDirection.trim().length() == 0 || sortDirection.trim().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

        Sort sort = Sort.by(direction, sortColumn);

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);

        Page result = taskService.findByParams(text, completed, priorityId, categoryId, pageRequest);

        return ResponseEntity.ok(result);
    }
}
