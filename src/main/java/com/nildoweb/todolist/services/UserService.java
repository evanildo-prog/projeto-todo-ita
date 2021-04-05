package com.nildoweb.todolist.services;

import java.util.List;
import java.util.Optional;

import com.nildoweb.todolist.dto.LoginRequestDTO;
import com.nildoweb.todolist.dto.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nildoweb.todolist.domain.Todo;
import com.nildoweb.todolist.domain.User;
import com.nildoweb.todolist.dto.UserDTO;
import com.nildoweb.todolist.repository.UserRepository;
import com.nildoweb.todolist.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public LoginResponseDTO authenticate(LoginRequestDTO dto) {
		var user = this.repo.findByName(dto.getUserName());
		if(user == null) return null;



		return new LoginResponseDTO();
	}
}
