import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Todo} from "../models/Todo";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  private apiUrl = "http://localhost:8080/api/todos/"

  constructor(
    private http:HttpClient
  ) {}

  getTodos(): Observable<Todo[]>{
    return this.http.get<Todo[]>(this.apiUrl);
  }

  updateTodoState(id:number): Observable<Todo>{
    return this.http.patch<Todo>(this.apiUrl+"/state/"+id, null)
  }

  getOneTodo(id:number): Observable<Todo>{
    return this.http.get<Todo>(this.apiUrl+id)
  }

  createOneTodo(todo:Todo): Observable<Todo>{
    return this.http.post<Todo>(this.apiUrl, todo)
  }
}
