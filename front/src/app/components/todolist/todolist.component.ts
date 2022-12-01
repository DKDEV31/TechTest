import {Component, OnInit} from '@angular/core';
import {Todo} from "../../models/Todo";
import {TodoService} from "../../services/todo.service";
import {catchError, of} from "rxjs";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-todolist',
  templateUrl: './todolist.component.html',
  styleUrls: ['./todolist.component.scss']
})
export class TodolistComponent implements OnInit{
  todos:Todo[] = []

  constructor(private todoService:TodoService, private _snackBar:MatSnackBar) {
  }

  ngOnInit(): void {
    this.fetchTodos()
  }

  updateTodoState(todo:Todo):void{
    console.log(todo)
    this.todoService.updateTodoState(todo.id!).pipe(
      catchError(() => {
        this.openSnackbar("An error occured while updating todo")
        return of({})
      })
    ).subscribe(() => {
      this.todoService.getTodos().subscribe(todos => this.todos = todos)
    })
  }

  fetchTodos():void{
    this.todoService.getTodos().pipe(
      catchError(() => {
        this.openSnackbar("An error occured while fetching todos")
        return of([])
      })
    ).subscribe(todos => this.todos = todos)
  }

  openSnackbar(message:string){
    this._snackBar.open(message, "close", {duration: 3000})
  }

}
