package dkdev.todotest.controller;

import dkdev.todotest.Exception.DAOException;
import dkdev.todotest.entity.Todo;
import dkdev.todotest.services.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos() throws DAOException {
        return ResponseEntity.ok(todoService.listAllTodos());
    }
}
