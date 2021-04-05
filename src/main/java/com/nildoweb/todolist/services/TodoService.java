package com.nildoweb.todolist.services;

import com.nildoweb.todolist.domain.Todo;
import com.nildoweb.todolist.dto.NewTodoDTO;
import com.nildoweb.todolist.dto.UpdateTodoDTO;
import com.nildoweb.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repo;

	public Todo add(NewTodoDTO dto) {
		var todo = NewTodoDTO.fromDto(dto);
		return this.repo.save(todo);
	}

	public List<Todo> listTodos(String userId, Boolean isPending) {
		if(isPending == null)
			return this.repo.findByUserIdOrderByPendingDesc(userId);

	    return this.repo.findByUserIdAndPendingOrderByPendingDesc(userId, isPending);
	}

	public Todo updateTodo(String id, UpdateTodoDTO dto) {
		var toUpdate = this.repo.findById(id).orElse(null);
		if(toUpdate == null) return null;

		toUpdate.setUpdateDate(LocalDateTime.now());
		toUpdate.setDescription(dto.getDescription());
		toUpdate.setSummary(dto.getSummary());
		toUpdate.setPending(dto.getPending());
		this.repo.save(toUpdate);

		return toUpdate;
	}

	public Todo deleteTodo(String id) {
	    var toDelete = this.repo.findById(id);
	    if(toDelete.isPresent()) this.repo.delete(toDelete.get());
	    return toDelete.orElse(null);
	}
}