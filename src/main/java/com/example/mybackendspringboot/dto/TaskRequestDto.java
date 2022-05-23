package com.example.mybackendspringboot.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
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
