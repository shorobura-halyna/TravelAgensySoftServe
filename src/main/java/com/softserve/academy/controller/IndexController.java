package com.softserve.academy.controller;

import com.softserve.academy.service.CountryService;
import com.softserve.academy.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    private  final HotelService hotelService;
    private final CountryService countryService;

    @Autowired
    public IndexController(HotelService hotelService, CountryService countryService) {
        this.hotelService = hotelService;
        this.countryService = countryService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("countries", countryService.getAll());
        model.addAttribute("hotels", hotelService.getAll());
        return "index";
    }

    @PostMapping("/")
    public String index() {
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(){
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "loginprocessing";
    }
}
