package com.springboot.ToDoProject.service;

import com.springboot.ToDoProject.model.ToDo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//this service method is used by ToDoController class
@Service
public class ToDoService {
    private static List<ToDo> todos=new ArrayList<>();
    private static int count=0;
    static
    {
        todos.add(new ToDo(++count,"Samuel","learn java fsd",
                LocalDate.now().plusYears(1),false));
        todos.add(new ToDo(++count,"linkedin Learning","learn Devops",
                LocalDate.now().plusYears(1),false));
        todos.add(new ToDo(++count,"Ievolve","learn azure",
                LocalDate.now().plusYears(1),false));
    }

    public List<ToDo> findByUsername(String username)
    {
        List<ToDo> toDoList=new ArrayList<>();
        for(ToDo todo:todos)
        {
            if(todo.getUsername().equalsIgnoreCase(username))
                toDoList.add(todo);
        }
        return toDoList;
    }

    public void addToDo(String username,String description,LocalDate target,boolean done)
    {
        ToDo todo=new ToDo(++count,username,description,target,done);
        todos.add(todo);
    }
    public void deleteById(int id)
    {
        for(ToDo t:todos)
        {
            if(t.getId()==id)
            {
                todos.remove(t);
                return;
            }
        }
    }

    public ToDo findById(int id) {
        for(ToDo t:todos)
        {
            if(t.getId()==id)
            {
                return t;
            }
        }
    return null;
    }

    public void updateToDo(@Valid @ModelAttribute ToDo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
