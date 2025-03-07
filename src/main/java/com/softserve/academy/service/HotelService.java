package com.softserve.academy.service;

import com.softserve.academy.model.Hotel;

import java.util.List;

public interface HotelService {
    void save(Hotel hotel, int countryId);

    void delete(int id);

    List<Hotel> getAll();

    Hotel getOne(int id);

    void update(int id, String name, String address, int countryId);

    List<Hotel> getAllCountryHotels(int id);
}
