import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TodoDetailComponent} from "./components/todo-detail/todo-detail.component";
import {TodolistComponent} from "./components/todolist/todolist.component";

const routes: Routes = [
  { path: '', component: TodolistComponent },
  {
  path: "todo/:id",
  component: TodoDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
