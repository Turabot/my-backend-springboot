package com.example.mybackendspringboot.service;

import com.example.mybackendspringboot.dto.CategoryDto;
import com.example.mybackendspringboot.entity.Category;
import com.example.mybackendspringboot.mapper.CategoryMapper;
import com.example.mybackendspringboot.service.db.CategoryDb;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryDb categoryDb;
    private final CategoryMapper mapper;

    public CategoryService(CategoryDb categoryDb, CategoryMapper mapper) {
        this.categoryDb = categoryDb;
        this.mapper = mapper;
    }

    public List<Category> getAllCategory() {
        return categoryDb.findAllByOrderByTitleAsc();
    }

    public Category getById(Long id) {
       return categoryDb.findById(id);
    }

    public Category save(CategoryDto categoryDto) {
        Category category = mapper.mapFrom(categoryDto);
        return categoryDb.add(category);
    }

    public List<Category> searchCategory(String title) {
        return categoryDb.findByTitle(title);
    }

    public void deleteCategory(Long id) {
        categoryDb.deleteCategoryById(id);
    }
}
