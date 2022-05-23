package com.example.mybackendspringboot.service;

import com.example.mybackendspringboot.dto.TaskRequestDto;
import com.example.mybackendspringboot.entity.Task;
import com.example.mybackendspringboot.exception.TaskNotFoundException;
import com.example.mybackendspringboot.mapper.TaskMapper;
import com.example.mybackendspringboot.repo.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;

    public TaskService(TaskRepository repository, TaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task add(TaskRequestDto taskRequestDto) {
        Task task = mapper.mapFrom(taskRequestDto);
        return repository.save(task);
    }

    public void update(TaskRequestDto taskRequestDto) {
        Task task = mapper.mapFrom(taskRequestDto);
        repository.save(task);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Page findByParams(String text, Integer completed, Long priorityId, Long categoryId, PageRequest paging) {
        return repository.findByParams(text, completed, priorityId, categoryId, paging);
    }

    public Task findById(Long id) {
        return repository.findById(id).orElseThrow(TaskNotFoundException::new);
    }
}
