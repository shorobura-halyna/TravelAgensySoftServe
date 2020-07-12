package com.softserve.academy.controller;

import com.softserve.academy.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    private final HotelService hotelService;

    @Autowired
    public AdminController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/adminPanel")
    public String showHotel(Model model) {
        model.addAttribute("hotels", hotelService.getAll());
        return "adminPanel";
    }
}
