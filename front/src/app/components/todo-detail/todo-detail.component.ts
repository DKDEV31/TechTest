import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {TodoService} from "../../services/todo.service";
import {Todo} from "../../models/Todo";
import {MatSnackBar} from "@angular/material/snack-bar";
import {catchError, of} from "rxjs";

@Component({
  selector: 'app-todo-detail',
  templateUrl: './todo-detail.component.html',
  styleUrls: ['./todo-detail.component.scss']
})
export class TodoDetailComponent implements OnInit{

  todo!:Todo

  constructor(private route:ActivatedRoute, private todoService:TodoService, private _snackbar:MatSnackBar) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe( paramMap => {
      this.todoService.getOneTodo(parseInt(<string>paramMap.get("id"))).pipe(
        catchError(() => {
          this.openSnackbar("An error occured while fetchnig the todo")
          return of({title: "", description: ""})
        })
      ).subscribe(todo => {
        this.todo = todo
      })
    })
  }

  openSnackbar(message:string){
    this._snackbar.open(message, "Close", {duration:3000})
  }

}
