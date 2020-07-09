package com.softserve.academy.service.impl;

import com.softserve.academy.dao.HotelDao;
import com.softserve.academy.model.Hotel;
import com.softserve.academy.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    private HotelDao hotelDao;

    @Autowired
    public HotelServiceImpl(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }

    @Override
    public void save(Hotel hotel) {
         hotelDao.save(hotel);
    }

    @Override
    public void delete(int id) {
        hotelDao.delete(id);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelDao.findAll();
    }
}
