package com.example.mybackendspringboot.mapper;

import com.example.mybackendspringboot.dto.PriorityDto;
import com.example.mybackendspringboot.entity.Priority;
import org.springframework.stereotype.Component;

@Component
public class PriorityMapper implements Mapper<PriorityDto, Priority>{

    @Override
    public Priority mapFrom(PriorityDto object) {
        return Priority.builder()
                .id(object.getId())
                .title(object.getTitle())
                .color(object.getColor())
                .build();
    }
}
