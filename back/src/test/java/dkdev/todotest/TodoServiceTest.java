package dkdev.todotest;

import dkdev.todotest.Exception.DAOException;
import dkdev.todotest.entity.Todo;
import dkdev.todotest.repository.TodoRepository;
import dkdev.todotest.services.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {
    @InjectMocks
    private TodoService todoService;

    @Mock
    private TodoRepository todoRepository;

    @Test
    public void TestFindAllThrowException() {
        when(todoRepository.findAll()).thenThrow(new RuntimeException());
        assertThatThrownBy(() -> todoService.listAllTodos()).isInstanceOf(Exception.class);
        verify(todoRepository).findAll();
    }

    @Test
    public void TestUpdateTodoStateThrowDAOException() {
        Todo todo = new Todo();
        when(todoRepository.findById(1L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> todoService.updateTodoState(1L)).isInstanceOf(DAOException.class);
        verify(todoRepository).findById(1L);
        verify(todoRepository, times(0)).save(todo);
    }
}
