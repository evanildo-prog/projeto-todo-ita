package com.nildoweb.todolist.resources;

import com.nildoweb.todolist.dto.LoginRequestDTO;
import com.nildoweb.todolist.dto.LoginResponseDTO;
import com.nildoweb.todolist.services.TodoService;
import com.nildoweb.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService service;

//	@RequestMapping(value="/{id}", method=RequestMethod.GET)
// 	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
//		Optional<User> obj = service.findById(id);
//		return obj.isPresent() ?
//			 ResponseEntity.ok().body(new UserDTO(obj.get().getId(), obj.get().getName(), obj.get().getEmail()))
//			: ResponseEntity.notFound().build();
//	}

	@PostMapping("/auth")
	public ResponseEntity<LoginResponseDTO> authenticate(@RequestBody LoginRequestDTO loginDto) {

	    return ResponseEntity.ok(null);
	}
}
