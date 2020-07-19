package com.softserve.academy.service.impl;

import com.softserve.academy.dao.CountryDao;
import com.softserve.academy.dao.HotelDao;
import com.softserve.academy.dao.RoomDao;
import com.softserve.academy.model.Country;
import com.softserve.academy.model.Hotel;
import com.softserve.academy.model.Room;
import com.softserve.academy.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {
    private final HotelDao hotelDao;
    private final RoomDao roomDao;
    private final CountryDao countryDao;

    @Autowired
    public HotelServiceImpl(HotelDao hotelDao, RoomDao roomDao, CountryDao countryDao) {
        this.hotelDao = hotelDao;
        this.roomDao = roomDao;
        this.countryDao = countryDao;
    }

    @Override
    public void save(Hotel hotel, int countryId) {
        Country country= countryDao.findOne(countryId);
        hotel.setCountry(country);
        hotelDao.save(hotel);
    }

    /**
     * Method deletes hotel with rooms
     * */
    @Override
    public void delete(int id) {
        Hotel hotel = hotelDao.findOne(id);
        for (Room room : hotel.getRooms()) {
            roomDao.delete(room.getId());
        }
        hotelDao.delete(id);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelDao.findAll();
    }

    @Override
    public Hotel getOne(int id) {
        return hotelDao.findOne(id);
    }

    @Override
    public void update(int id, String name, String address, int countryId) {
        Hotel hotel = hotelDao.findOne(id);
        Country country = countryDao.findOne(countryId);
        hotel.setName(name);
        hotel.setAddress(address);
        hotel.setCountry(country);
        hotelDao.save(hotel);
    }

    @Override
    public List<Hotel> getAllCountryHotel(int id) {
        return hotelDao.getAllCountryHotel(id);
    }
}
