import {Component, Input} from '@angular/core';
import {Todo} from "../../models/Todo";

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent {

  @Input() todo!:Todo;

  onChange(){
    this.todo.state = !this.todo.state
    console.log("change")
  }

}
