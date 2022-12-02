import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Todo} from "../models/Todo";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  private apiUrl = "/api"

  constructor(
    private http:HttpClient
  ) {}

  getTodos(): Observable<Todo[]>{
    return this.http.get<Todo[]>(this.apiUrl+"/todos/");
  }

  updateTodoState(id:number): Observable<Todo>{
    return this.http.patch<Todo>(this.apiUrl+"/todos/state/"+id, null)
  }

  getOneTodo(id:number): Observable<Todo>{
    return this.http.get<Todo>(this.apiUrl+"/todos/"+id)
  }

  createOneTodo(todo:Todo): Observable<Todo>{
    return this.http.post<Todo>(this.apiUrl+"/todos/", todo)
  }
}
