import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Todo} from "../../models/Todo";

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent {

  @Input() todo!:Todo;

  @Output() todoUpdatedState = new EventEmitter<Todo>()

  onChange(){
    this.todo.state = !this.todo.state
    this.todoUpdatedState.emit({
      ...this.todo
    })
  }

}
