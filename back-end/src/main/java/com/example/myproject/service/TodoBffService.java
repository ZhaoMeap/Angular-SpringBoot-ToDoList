package com.example.myproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.myproject.dto.TodoDTO;
import com.example.myproject.entity.Todo;

@Service
public class TodoBffService {
    private final TodoService todoService;

    public TodoBffService(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<TodoDTO> getIncompleteTodos() {
        return todoService.getAllTodos().stream()
                .filter(todo -> !todo.getCompleted())
                .map(todo -> new TodoDTO(todo.getTitle(), todo.getCompleted()))
                .collect(Collectors.toList());
    }

    public List<TodoDTO> getCompletedTodos() {
        return todoService.getAllTodos().stream()
                .filter(Todo::getCompleted)
                .map(todo -> new TodoDTO(todo.getTitle(), todo.getCompleted()))
                .collect(Collectors.toList());
    }
}
