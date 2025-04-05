package com.example.myproject.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.example.myproject.service.TodoBffService;
import com.example.myproject.service.TodoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.myproject.dto.TodoDTO;
import com.example.myproject.entity.Todo;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@Tag(name = "BFF Todo Management", description = "針對前端需求優化的 Todo CRUD API")
public class TodoController {

    private final TodoBffService todoBffService;
    private final TodoService todoService;

    public TodoController(TodoService todoService, TodoBffService todoBffService) {
        this.todoBffService = todoBffService;
        this.todoService = todoService;
    }

    @GetMapping("/getAllTodos")
    @Operation(summary = "取得所有 Todo 清單", description = "取得目前資料庫中所有的 Todo 項目")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/getTodoById/{id}")
    @Operation(summary = "取得指定 ID 的 Todo", description = "取得指定 ID 的 Todo 項目")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id);
        return todo != null ? ResponseEntity.ok(todo) : ResponseEntity.notFound().build();
    }

    @PostMapping("/createTodo")
    @Operation(summary = "新增 Todo 項目")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping("/updateTodo/{id}")
    @Operation(summary = "修改指定 ID 的 Todo")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodo(id, todo);
        return updatedTodo != null ? ResponseEntity.ok(updatedTodo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteTodo/{id}")
    @Operation(summary = "刪除指定 ID 的 Todo")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/getIncompleteTodos")
    @Operation(summary = "取得所有未完成的 Todo", description = "取得目前資料庫中所有未完成的 Todo 項目")
    public List<TodoDTO> getIncompleteTodos() {
        return todoBffService.getIncompleteTodos();
    }

    @GetMapping("/getCompletedTodos")
    @Operation(summary = "取得所有已完成的 Todo", description = "取得目前資料庫中所有已完成的 Todo 項目")
    public List<TodoDTO> getCompletedTodos() {
        return todoBffService.getCompletedTodos();
    }
}
