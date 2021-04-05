package com.nildoweb.todolist.resources;

import com.nildoweb.todolist.dto.GetTodoDTO;
import com.nildoweb.todolist.dto.NewTodoDTO;
import com.nildoweb.todolist.dto.UpdateTodoDTO;
import com.nildoweb.todolist.services.TodoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/todo")
public class TodoResource {
	@Autowired
	private TodoService service;

	@PostMapping()
	public ResponseEntity<?> addTodo(@RequestBody NewTodoDTO toAdd) {
		var addedTodo = this.service.add(toAdd);
		return ResponseEntity.ok(addedTodo);
	}

	@GetMapping()
	public ResponseEntity<List<GetTodoDTO>> getTodos(@RequestParam(value = "userId", required = true) String userId, @RequestParam(value = "pending", required = false) Boolean isPending) {
	    var todos = this.service.listTodos(userId, isPending);
	    var ret = GetTodoDTO.fromTodo(todos);
		return ret.isEmpty() || ret == null ?
				ResponseEntity.notFound().build()
				: ResponseEntity.ok(ret);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateTodo(@PathVariable String id, @RequestBody UpdateTodoDTO dto) {
		var updated = this.service.updateTodo(id, dto);
		return updated == null ?
				ResponseEntity.notFound().build()
				: ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<GetTodoDTO> deleteTodo(@PathVariable String id) {
	    var deleted = this.service.deleteTodo(id);
	    return deleted == null ?
				ResponseEntity.notFound().build()
				: ResponseEntity.ok(GetTodoDTO.fromTodo(deleted));
	}
}
