package com.nildoweb.todolist.dto;

import com.nildoweb.todolist.domain.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class GetTodoDTO {
    private String id;
    private String summary;
    private String description;
    private Boolean pending;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public static List<GetTodoDTO> fromTodo(List<Todo> todos) {
        return todos.stream()
                .map(GetTodoDTO::fromTodo)
                .collect(Collectors.toList());
    };

    public static GetTodoDTO fromTodo(Todo todo) {
        return new GetTodoDTO(todo.getId(), todo.getSummary(), todo.getDescription(), todo.getPending(), todo.getCreationDate(), todo.getUpdateDate());
    };
}
