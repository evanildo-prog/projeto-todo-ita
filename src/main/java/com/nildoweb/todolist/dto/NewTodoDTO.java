package com.nildoweb.todolist.dto;

import com.nildoweb.todolist.domain.Todo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class NewTodoDTO {
    private String summary;
    private String description;
    private String userId;

    public static Todo fromDto(NewTodoDTO dto) {
        return new Todo(UUID.randomUUID().toString(), LocalDateTime.now(), dto.getSummary(), dto.getDescription(), true, LocalDateTime.now(), dto.getUserId());
    }
}
