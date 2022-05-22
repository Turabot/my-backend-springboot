package com.example.mybackendspringboot.controller;

import com.example.mybackendspringboot.dto.CategoryDto;
import com.example.mybackendspringboot.entity.Category;
import com.example.mybackendspringboot.repo.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostMapping("/add")
    public Category add(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Category>> search(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryRepository.findByTitle(categoryDto.getTitle()));
    }
}
