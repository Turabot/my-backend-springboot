package com.example.mybackendspringboot.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PriorityDto {

    Long id;
    String title;
    String color;
}
