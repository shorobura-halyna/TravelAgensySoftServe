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

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String login,
                               @RequestParam String password){
        userService.save(new User(firstName, lastName, login, password));
        return "redirect:/";
    }

    @GetMapping("/user")
    public String room(Model model) {
        model.addAttribute("users", userService.getAll());
        return "user";
    }


}
