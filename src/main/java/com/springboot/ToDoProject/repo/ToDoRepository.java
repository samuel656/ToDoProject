package com.springboot.ToDoProject.repo;

import com.springboot.ToDoProject.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Integer> {
    public List<ToDo> findByUsername(String username);
}
