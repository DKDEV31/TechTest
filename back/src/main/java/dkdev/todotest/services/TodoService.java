package dkdev.todotest.services;

import dkdev.todotest.Exception.DAOException;
import dkdev.todotest.entity.Todo;
import dkdev.todotest.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
}
