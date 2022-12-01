package dkdev.todotest.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

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

    public Todo() {
    }
}