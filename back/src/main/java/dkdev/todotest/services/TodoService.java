package dkdev.todotest.services;

import dkdev.todotest.Exception.DAOException;
import dkdev.todotest.entity.Todo;
import dkdev.todotest.repository.TodoRepository;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> listAllTodos() {
            return todoRepository.findAll();
    }

    public Todo updateTodoState(Long id) throws DAOException {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new DAOException("Todo not found please give a valid id"));
        todo.setState(!todo.getState());
        return todoRepository.save(todo);
    }

    public Todo getOneTodoById(Long id) throws DAOException {
        return todoRepository.findById(id).orElseThrow(() -> new DAOException("Todo not found please give a valid id"));
    }

    public Todo createNewTodo(Todo todo){
            todo.setState(false);
            todo.setCreatedAt(new Date());
            return todoRepository.save(todo);
    }
}
