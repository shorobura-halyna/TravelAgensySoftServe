package com.softserve.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    private String registration() {
        return "registration";
    }

    @GetMapping("/login")
    private String login() {
        return "login";
    }


}
