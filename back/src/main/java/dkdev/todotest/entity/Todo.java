package dkdev.todotest.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;
    @Column(name = "state", nullable = false)
    private Boolean state;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    public Todo() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Todo todo = (Todo) o;
        return id != null && Objects.equals(id, todo.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}