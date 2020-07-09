package com.softserve.academy.controller;

import com.softserve.academy.model.Hotel;
import com.softserve.academy.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/createHotel")
    public String save(Model model){
        model.addAttribute("hotels", hotelService.getAll());
        return "createHotel";
    }

    @PostMapping("/createHotel")
    public String save(@RequestParam String name,
                       @RequestParam String address){
        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setAddress(address);
        hotelService.save(hotel);
        return "redirect:/hotel";
    }

    @GetMapping("/hotel")
    public String user(Model model){
        model.addAttribute("hotels", hotelService.getAll());
        return "hotel";
    }

    @GetMapping("/deleteHotel/{id}")
    public String delete(@PathVariable int id){
        hotelService.delete(id);
        return "redirect:/hotel";
    }
}
