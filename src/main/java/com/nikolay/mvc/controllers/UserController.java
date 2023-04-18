package com.nikolay.mvc.controllers;

import com.nikolay.mvc.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserDAO userDAO;
    @Autowired
    public UserController(UserDAO userDAO){
        this.userDAO= userDAO;
    }
    @GetMapping()
    public String allUsers(Model model){
        model.addAttribute("users",userDAO.getAll());
        return "allUsers";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userDAO.getById(id));
        return "getById";
    }
}
