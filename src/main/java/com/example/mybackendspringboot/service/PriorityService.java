package com.example.mybackendspringboot.service;

import com.example.mybackendspringboot.dto.PriorityDto;
import com.example.mybackendspringboot.entity.Priority;
import com.example.mybackendspringboot.exception.PriorityNotFoundException;
import com.example.mybackendspringboot.mapper.PriorityMapper;
import com.example.mybackendspringboot.repo.PriorityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityService {

    private final PriorityRepository priorityRepository;
    private final PriorityMapper mapper;

    public PriorityService(PriorityRepository priorityRepository, PriorityMapper mapper) {
        this.priorityRepository = priorityRepository;
        this.mapper = mapper;
    }

    public List<Priority> findAll() {
        return priorityRepository.findAllByOrderByIdAsc();
    }

    public Priority add(PriorityDto priorityDto) {
        Priority priority = mapper.mapFrom(priorityDto);
        return priorityRepository.save(priority);
    }

    public void update(PriorityDto priorityDto) {
        Priority priority = mapper.mapFrom(priorityDto);
        priorityRepository.save(priority);
    }

    public void deleteById(Long id) {
        priorityRepository.deleteById(id);
    }

    public Priority findById(Long id) {
        return priorityRepository.findById(id).orElseThrow(PriorityNotFoundException::new);
    }

    public List<Priority> findByTitle(String text) {
        return priorityRepository.findByTitle(text);
    }
}
