package com.softserve.academy.controller;

import com.softserve.academy.model.User;
import com.softserve.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/createUser")
    public String save(Model model){
        model.addAttribute("users", userService.getAll());
        return "createUser";
    }

    @PostMapping("/createUser")
    public String save(@RequestParam String firstName,
                       @RequestParam String lastName){
        userService.save(new User(firstName, lastName));
        return "redirect:/user";
    }

    @GetMapping("/user")
    public String user(Model model){
        model.addAttribute("users", userService.getAll());
        return "user";
    }

    @GetMapping("/deleteUser/{id}")
    public String delete(@PathVariable int id){
        userService.delete(id);
        return "redirect:/user";
    }
}
