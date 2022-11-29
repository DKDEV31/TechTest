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

    public List<Todo> listAllTodos() throws DAOException {
        try{
            return todoRepository.findAll();
        } catch (Exception e) {
            throw new DAOException(e.getMessage());
        }
    }
}
