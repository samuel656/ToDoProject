package com.springboot.ToDoProject.controller;

import com.springboot.ToDoProject.model.ToDo;
import com.springboot.ToDoProject.repo.ToDoRepository;
import com.springboot.ToDoProject.service.ToDoService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("uname")
public class ToDoControllerJPA {
    private ToDoRepository toDoRepository;

    public ToDoControllerJPA(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @RequestMapping("list-todos")
    public String getTodoList(ModelMap model)
    {
        String username = getLoggedInUserName();
       List<ToDo> todos=toDoRepository.findByUsername(username);
        model.put("todos",todos);
        return "todoList";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showToDO(ModelMap model, HttpSession session) {
        String username = (String) session.getAttribute("uname");
        ToDo todo = new ToDo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "addTodo";
    }



    @RequestMapping(value="add-todo", method = RequestMethod.POST)
    public String addNewToDO(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "addTodo";
        }
        String username=getLoggedInUserName();
        todo.setUsername(username);
        toDoRepository.save(todo);

        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteToDO(@RequestParam int id)
    {
        toDoRepository.deleteById(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value="update-todo",method = RequestMethod.GET)
    public String showUpdateToDO(@RequestParam int id,ModelMap model)
    {
        ToDo todo=toDoRepository.findById(id).get();
        model.addAttribute("todo",todo);
        return "addTodo";
    }
    @RequestMapping(value="update-todo",method = RequestMethod.POST)
    public String UpdateToDo(@Valid @ModelAttribute("todo") ToDo todo, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "addTodo";
        }
        String username=getLoggedInUserName();
        todo.setUsername(username);
        toDoRepository.save(todo);
        return "redirect:list-todos";
    }

    private String getLoggedInUserName()
    {
        Authentication authentication=
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();

    }
}
