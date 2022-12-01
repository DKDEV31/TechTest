import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {TodoService} from "../../services/todo.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {catchError, of} from "rxjs";

@Component({
  selector: 'app-todo-create',
  templateUrl: './todo-create.component.html',
  styleUrls: ['./todo-create.component.scss']
})
export class TodoCreateComponent {

  constructor(private fb: FormBuilder, private router:Router, private todoService:TodoService, private _snackBar:MatSnackBar) {

  }

  TodoForm:FormGroup = this.fb.group({
    title:["", Validators.required],
    description: [""]
  })

  submit(){
    this.todoService.createOneTodo(this.TodoForm.value).pipe(
      catchError(() => {
        this.openSnackbar("An error occured while creating a todo")
        return of({})
      })
    ).subscribe(() => {
      this.router.navigate(["/"])
    })
  }

  openSnackbar(message:string){
    this._snackBar.open(message, "Close", {duration:3000})
  }
}
