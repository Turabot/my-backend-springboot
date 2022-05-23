package com.example.mybackendspringboot.dto;

import com.example.mybackendspringboot.entity.Category;
import com.example.mybackendspringboot.entity.Priority;
import lombok.Builder;
import lombok.Value;

import java.util.Date;

@Value
@Builder
public class TaskDto {

    Long id;
    String title;
    Integer completed;
    Date date;
    Priority priority;
    Category category;
}
