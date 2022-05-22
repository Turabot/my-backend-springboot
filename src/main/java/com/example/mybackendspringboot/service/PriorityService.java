package com.example.mybackendspringboot.service;

import com.example.mybackendspringboot.repo.PriorityRepository;
import org.springframework.stereotype.Service;

@Service
public class PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

}
