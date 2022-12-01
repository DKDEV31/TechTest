package dkdev.todotest;

import dkdev.todotest.entity.Todo;
import dkdev.todotest.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TodoJPATest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void TestSortedListOfTodos() {
        Todo todo1 = new Todo();
        todo1.setState(false);
        todo1.setTitle("Todo 1");
        todo1.setDescription("Todo 1 description");
        todo1.setCreatedAt(new Date());
        Todo todo2 = new Todo();
        todo2.setState(true);
        todo2.setTitle("Todo 2");
        todo2.setDescription("Todo 2 description");
        Date date = new Date();
        date.setTime(date.getTime() + 1000);
        todo2.setCreatedAt(date);
        entityManager.persist(todo1);
        entityManager.persist(todo2);
        entityManager.flush();
        List<Todo> todos = todoRepository.findAll();
        assertThat(todos.get(0).getTitle()).isEqualTo("Todo 1");
    }
}
