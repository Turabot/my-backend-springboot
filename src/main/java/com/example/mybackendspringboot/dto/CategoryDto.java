package com.example.mybackendspringboot.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CategoryDto {

    Long id;
    String title;
}
