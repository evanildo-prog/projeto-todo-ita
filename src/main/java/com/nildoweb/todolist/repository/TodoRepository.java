package com.nildoweb.todolist.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nildoweb.todolist.domain.Todo;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
    List<Todo> findByUserIdAndPendingOrderByPendingDesc(String userId, Boolean pending);
    List<Todo> findByUserIdOrderByPendingDesc(String userId);
}
