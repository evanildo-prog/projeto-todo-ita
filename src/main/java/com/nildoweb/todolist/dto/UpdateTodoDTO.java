package com.nildoweb.todolist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTodoDTO {
    private String summary;
    private String description;
    private Boolean pending;
}
