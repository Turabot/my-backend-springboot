package com.example.mybackendspringboot.dto;

import com.example.mybackendspringboot.entity.Category;
import com.example.mybackendspringboot.entity.Priority;
import lombok.Value;

import java.util.Date;

@Value
public class TaskRequestDto {

    String title;
    Integer completed;
    Date date;
    Priority priority;
    Category category;

    Integer pageNumber;
    Integer pageSize;

    String sortColumn;
    String sortDirection;
}
