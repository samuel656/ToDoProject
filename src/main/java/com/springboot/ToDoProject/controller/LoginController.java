package com.springboot.ToDoProject.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("uname")
public class LoginController {
    @RequestMapping(value="/",method=RequestMethod.GET)
    public String goToWelcome(ModelMap model) {
        model.put("uname", getLoggedInUserName());
        return "welcome";
    }
private String getLoggedInUserName()
{
    Authentication authentication=
            SecurityContextHolder.getContext().getAuthentication();
    return authentication.getName();

}

}
