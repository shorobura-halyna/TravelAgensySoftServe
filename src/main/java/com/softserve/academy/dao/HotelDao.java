package com.softserve.academy.dao;

import com.softserve.academy.model.Hotel;

import java.util.List;

public interface HotelDao extends GeneralDao<Hotel, Integer> {
    List<Hotel> getAllCountryHotels(int id);
}
