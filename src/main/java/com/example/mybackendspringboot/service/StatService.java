package com.example.mybackendspringboot.service;

import com.example.mybackendspringboot.entity.Stat;
import com.example.mybackendspringboot.repo.StatRepository;
import org.springframework.stereotype.Service;

@Service
public class StatService {

    private final StatRepository repository;

    public StatService(StatRepository repository) {
        this.repository = repository;
    }

    public Stat findById(Long id){
        return repository.findById(id).get();
    }
}
