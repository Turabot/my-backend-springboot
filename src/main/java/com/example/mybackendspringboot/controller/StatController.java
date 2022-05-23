package com.example.mybackendspringboot.controller;

import com.example.mybackendspringboot.entity.Stat;
import com.example.mybackendspringboot.service.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stat")
@CrossOrigin(origins = "http://localhost:4200")
public class StatController {

    private final StatService statService;

    public StatController(StatService statService) {
        this.statService = statService;
    }

    @GetMapping("/stat")
    public ResponseEntity<Stat> findById() {
        Long defaultId = 1L;
        return ResponseEntity.ok(statService.findById(defaultId));
    }
}
