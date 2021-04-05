package com.nildoweb.todolist.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Todo {

	@Id
	private String id;
	private LocalDateTime creationDate;
	private String summary;
	private String description;
	private Boolean pending;
	private LocalDateTime updateDate;
	private String userId;
}
