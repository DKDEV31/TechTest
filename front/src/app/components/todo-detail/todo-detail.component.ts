import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {TodoService} from "../../services/todo.service";
import {Todo} from "../../models/Todo";

@Component({
  selector: 'app-todo-detail',
  templateUrl: './todo-detail.component.html',
  styleUrls: ['./todo-detail.component.scss']
})
export class TodoDetailComponent implements OnInit{

  todo!:Todo

  constructor(private route:ActivatedRoute, private todoService:TodoService) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe( paramMap => {
      this.todoService.getOneTodo(parseInt(<string>paramMap.get("id"))).subscribe(todo => {
        this.todo = todo
      })
    })
  }


}
