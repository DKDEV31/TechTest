package dkdev.todotest;

import dkdev.todotest.Exception.DAOException;
import dkdev.todotest.repository.TodoRepository;
import dkdev.todotest.services.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {
    @InjectMocks
    private TodoService todoService;

    @Mock
    private TodoRepository todoRepository;

    @Test
    public void TestServiceThrowException() {
        when(todoRepository.findAll()).thenThrow(new RuntimeException());
        assertThatThrownBy(() -> todoService.listAllTodos()).isInstanceOf(DAOException.class);
        verify(todoRepository).findAll();
    }
}
