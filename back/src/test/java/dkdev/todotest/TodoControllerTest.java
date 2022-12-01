package dkdev.todotest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Sql("testTodos.sql")
    public void TestReturningTodosWhenAllIsOk() throws Exception {
        this.mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(4))
                .andExpect(jsonPath("$[1].id").value(5));
    }

    @Test
    @Sql("testTodos.sql")
    public void TestUpdatingTodoStateWhenAllIsOk() throws Exception {
       this.mockMvc.perform(patch("/todos/state/4"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$.id").value(4))
               .andExpect(jsonPath("$.state").value(true));
    }

    @Test
    @Sql("testTodos.sql")
    public void TestUpdatingTodoStateWhenTodoDoesNotExist() throws Exception {
        this.mockMvc.perform(patch("/todos/state/1"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Todo not found please give a valid id"));
    }

    @Test
    @Sql("testTodos.sql")
    public void TestGettingOneTodoByIdWhenAllIsOk() throws Exception {
        this.mockMvc.perform(get("/todos/5"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(5))
                .andExpect(jsonPath("$.description").value("Utiliser le nouvel aspirateur"));
    }
}
