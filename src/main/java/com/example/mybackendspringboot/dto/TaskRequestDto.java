package com.example.mybackendspringboot.dto;

import lombok.Value;

@Value
public class TaskRequestDto {

    String title;
    Integer completed;
    Long priorityId;
    Long categoryId;

    Integer pageNumber;
    Integer pageSize;

    String sortColumn;
    String sortDirection;
}
