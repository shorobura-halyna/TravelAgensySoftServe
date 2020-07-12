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
    public String save(){
        return "createHotel";
    }


    @PostMapping("/createHotel")
    public String save(@RequestParam String name,
                       @RequestParam String address){
        Hotel hotel = new Hotel();
        hotel.setName(name);
        hotel.setAddress(address);
        hotelService.save(hotel);
        return "redirect:/adminPanel";
    }

    @GetMapping("/updateHotel/{id}")
    public String update(Model model, @PathVariable int id) {
        model.addAttribute("oldHotel", hotelService.getOne(id));
        return "updateHotel";
    }

    @PostMapping("/updateHotel/{id}")
    public String update(@RequestParam String name,
                         @RequestParam String address,
                         @PathVariable int id){
        hotelService.update(id, name, address);
        return "redirect:/adminPanel";
    }

    @GetMapping("/deleteHotel/{id}")
    public String delete(@PathVariable int id){
        hotelService.delete(id);
        return "redirect:/adminPanel";
    }
}
