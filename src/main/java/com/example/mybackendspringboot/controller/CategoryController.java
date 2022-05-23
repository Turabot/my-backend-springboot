package com.example.mybackendspringboot.controller;

import com.example.mybackendspringboot.dto.CategoryDto;
import com.example.mybackendspringboot.entity.Category;
import com.example.mybackendspringboot.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Category> findAll() {
        return categoryService.getAllCategory();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
       return ResponseEntity.ok(categoryService.getById(id));
    }

    @PostMapping("/add")
    public Category createCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Category>> search(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.searchCategory(categoryDto.getTitle()));
    }

    @PutMapping("/update")
    public void update(@RequestBody CategoryDto categoryDto) {
        categoryService.updateCategory(categoryDto);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
