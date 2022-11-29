package dkdev.todotest.repository;

import dkdev.todotest.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
   @Query("SELECT t FROM Todo t ORDER BY t.state ASC, t.createdAt DESC")
    List<Todo> findAll();

}