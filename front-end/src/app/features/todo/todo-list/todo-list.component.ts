import { Component, OnInit } from '@angular/core';
import { Todo } from '../../../core/models/todo.model';
import { TodoService } from '../../../core/services/todo.service';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.scss'
})
export class TodoListComponent implements OnInit {
  todos: Todo[] = [];
  todoForm!: FormGroup;

  constructor(private todoService: TodoService, private fb: FormBuilder) {
    this.todoForm = this.fb.group({
      title: ['', Validators.required],
      description: [''],
      completed: [false]
    });
  }

  ngOnInit(): void {
    this.loadTodos();
  }

  loadTodos(): void {
    this.todoService.getTodos().subscribe((data) => {
      this.todos = data;
    });
  }

  addTodo(): void {
    if(this.todoForm.invalid) return;

    const newTodo: Todo = this.todoForm.value;

    this.todoService.createTodo(newTodo).subscribe(() => {
      this.todoForm.reset({
        title: '',
        description: '',
        completed: false
      });
      this.loadTodos();
    });
  }

  toggleTodo(todo: Todo): void {
    const updated = { ...todo, completed: !todo.completed };
    this.todoService.updateTodo(todo.id!, updated).subscribe(() => {
      this.loadTodos();
    });
  }

  deleteTodo(id: number): void {
    this.todoService.deleteTodo(id).subscribe(() => {
      this.loadTodos();
    });
  }

}
