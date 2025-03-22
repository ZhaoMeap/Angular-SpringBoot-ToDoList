import { Component, OnInit } from '@angular/core';
import { Todo } from '../../../core/models/todo.model';
import { TodoService } from '../../../core/services/todo.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.scss'
})
export class TodoListComponent implements OnInit {
  todos: Todo[] = [];
  newTitle: string = '';

  constructor(private todoService: TodoService) {}

  ngOnInit(): void {
    this.loadTodos();
  }

  loadTodos(): void {
    this.todoService.getTodos().subscribe((data) => {
      this.todos = data;
    });
  }

  addTodo(): void {
    if(!this.newTitle.trim()) return;
    const newTodo: Todo = { title: this.newTitle, completed: false};
    this.todoService.createTodo(newTodo).subscribe(() => {
      this.newTitle = '';
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
