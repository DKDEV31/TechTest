import {Component, OnInit} from '@angular/core';
import {Todo} from "../../models/Todo";
import {TodoService} from "../../services/todo.service";

@Component({
  selector: 'app-todolist',
  templateUrl: './todolist.component.html',
  styleUrls: ['./todolist.component.scss']
})
export class TodolistComponent implements OnInit{
  todos:Todo[] = []

  constructor(private todoService:TodoService) {
  }

  ngOnInit(): void {
    this.fetchTodos()
  }

  updateTodoState(todo:Todo):void{
    console.log(todo)
    this.todoService.updateTodoState(todo.id!).subscribe(() => this.todoService.getTodos().subscribe(todos => this.todos = todos))
  }

  fetchTodos():void{
    this.todoService.getTodos().subscribe(
      todos => this.todos = todos
    )
  }

}
