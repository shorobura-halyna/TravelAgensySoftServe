package com.softserve.academy.controller;

import com.softserve.academy.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private  final HotelService hotelService;

    @Autowired
    public IndexController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("hotels",hotelService.getAll());
        return "index";
    }

}
