package com.example.mybackendspringboot.mapper;

import com.example.mybackendspringboot.dto.TaskRequestDto;
import com.example.mybackendspringboot.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper implements Mapper<TaskRequestDto, Task> {

    @Override
    public Task mapFrom(TaskRequestDto object) {
        return null;
    }
}
