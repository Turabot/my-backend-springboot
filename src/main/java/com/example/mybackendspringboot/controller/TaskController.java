package com.example.mybackendspringboot.controller;

import com.example.mybackendspringboot.dto.TaskRequestDto;
import com.example.mybackendspringboot.entity.Task;
import com.example.mybackendspringboot.repo.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Task>> search(@RequestBody TaskRequestDto taskRequestDto) {

//        Long priorityId = taskRequestDto.getPriority().getId() != null ? taskRequestDto.getPriority().getId() : 1;
//        Long categoryId = taskRequestDto.getCategory().getId() != null ? taskRequestDto.getCategory().getId() : 1;

        Sort sort = Sort.by(taskRequestDto.getSortDirection() == null || taskRequestDto.getSortDirection().trim().length() == 0 || taskRequestDto.getSortDirection().trim().equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, taskRequestDto.getSortColumn());
        
        PageRequest pageRequest = PageRequest.of(taskRequestDto.getPageNumber(), taskRequestDto.getPageSize(), sort);

        Page<Task> result = taskRepository.findByParams(taskRequestDto.getTitle(), taskRequestDto.getCompleted(), 5L, 7L, pageRequest);

        return ResponseEntity.ok(result);
    }
}
