package com.example.mybackendspringboot.service;

import com.example.mybackendspringboot.entity.Priority;
import com.example.mybackendspringboot.repo.PriorityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }


    public List<Priority> findAll() {
        return priorityRepository.findAllByOrderByIdAsc();
    }

    public Priority add(Priority priority) {
        return priorityRepository.save(priority); // метод save обновляет или создает новый объект, если его не было
    }

    public Priority update(Priority priority){
        return priorityRepository.save(priority); // метод save обновляет или создает новый объект, если его не было
    }

    public void deleteById(Long id){
        priorityRepository.deleteById(id);
    }

    public Priority findById(Long id){
        return priorityRepository.findById(id).get(); // т.к. возвращается Optional - нужно получить объект методом get()
    }

    public List<Priority> findByTitle(String text){
        return priorityRepository.findByTitle(text);
    }
}
