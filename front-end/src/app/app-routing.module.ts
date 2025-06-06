import { Routes } from '@angular/router';
import { TodoListComponent } from './features/todo/todo-list/todo-list.component';

export const routes: Routes = [
  { path: '', redirectTo: 'todos', pathMatch: 'full' },
  { path: 'todos', component: TodoListComponent }
];