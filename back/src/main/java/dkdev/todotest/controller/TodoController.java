package dkdev.todotest.controller;

import dkdev.todotest.Exception.DAOException;
import dkdev.todotest.entity.Todo;
import dkdev.todotest.services.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.List;
@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping(value = "/todos", produces = "application/json")
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(todoService.listAllTodos());
    }

    @PatchMapping(value = "/todos/state/{id}", produces = "application/json")
    public ResponseEntity<Todo> updateTodoState(@PathVariable Long id) throws DAOException {
        return ResponseEntity.ok(todoService.updateTodoState(id));
    }

    @GetMapping(value = "/todos/{id}", produces = "application/json")
    public ResponseEntity<Todo> getOneTodoById(@PathVariable Long id) throws DAOException {
        return ResponseEntity.ok(todoService.getOneTodoById(id));
    }

    @PostMapping(value = "/todos", produces = "application/json")
    public ResponseEntity<Todo> createNewTodo(@RequestBody @Valid Todo todo) {
        return ResponseEntity.ok(todoService.createNewTodo(todo));
    }
}
