package com.springboot.ToDoProject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String username;

    @Size(min=10,message="Enter atleast 10 characters")
    String description;

    LocalDate target;
    boolean done;

    public ToDo() {
    }

    public ToDo(int id, String username, String description, LocalDate target, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.target = target;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTarget() {
        return target;
    }

    public void setTarget(LocalDate target) {
        this.target = target;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", author='" + username + '\'' +
                ", description='" + description + '\'' +
                ", target=" + target +
                ", done=" + done +
                '}';
    }
}
