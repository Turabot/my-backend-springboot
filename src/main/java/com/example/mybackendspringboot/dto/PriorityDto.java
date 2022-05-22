package com.example.mybackendspringboot.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PriorityDto {

    String title;
    String color;
}
