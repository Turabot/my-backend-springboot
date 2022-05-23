package com.example.mybackendspringboot.mapper;

import com.example.mybackendspringboot.dto.CategoryDto;
import com.example.mybackendspringboot.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements Mapper<CategoryDto, Category>{

    @Override
    public Category mapFrom(CategoryDto object) {
        return Category.builder()
                .id(object.getId())
                .title(object.getTitle())
                .build();
    }
}
