package com.example.mybackendspringboot.service.db;

import com.example.mybackendspringboot.entity.Category;
import com.example.mybackendspringboot.repo.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryDb {

    private final CategoryRepository categoryRepository;

    public CategoryDb(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<Category> findAllByOrderByTitleAsc() {
        return categoryRepository.findAllByOrderByTitleAsc();
    }

    @Transactional(readOnly = true)
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Transactional
    public Category add(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional(readOnly = true)
    public List<Category> findByTitle(String title) {
       return categoryRepository.findByTitle(title);
    }

    @Transactional
    public void updateCategory(Long id, String title) {
        Category category = categoryRepository.findById(id).get();
        category.setTitle(title);
    }

    @Transactional
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
