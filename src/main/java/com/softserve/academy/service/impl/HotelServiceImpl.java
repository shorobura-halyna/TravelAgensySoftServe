package com.softserve.academy.service.impl;

import com.softserve.academy.dao.HotelDao;
import com.softserve.academy.dao.RoomDao;
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

    @Autowired
    public HotelServiceImpl(HotelDao hotelDao, RoomDao roomDao) {
        this.hotelDao = hotelDao;
        this.roomDao = roomDao;
    }

    @Override
    public void save(Hotel hotel) {
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
    public void update(int id, String name, String address) {
        Hotel hotel = hotelDao.findOne(id);
        hotel.setName(name);
        hotel.setAddress(address);
        hotelDao.save(hotel);
    }
}
