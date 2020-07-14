package com.softserve.academy.service.impl;

import com.softserve.academy.dao.HotelDao;
import com.softserve.academy.dao.RoomDao;
import com.softserve.academy.model.Hotel;
import com.softserve.academy.model.Room;
import com.softserve.academy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    private final RoomDao roomDao;
    private final HotelDao hotelDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao, HotelDao hotelDao) {
        this.roomDao = roomDao;
        this.hotelDao = hotelDao;
    }

    @Override
    public void save(Room room, int hotelId) {
        Hotel hotel = hotelDao.findOne(hotelId);
        room.setHotel(hotel);
        roomDao.save(room);
    }

    @Override
    public void delete(int id) {
        roomDao.delete(id);
    }

    @Override
    public List<Room> getAllHotelRooms(int id) {
        return roomDao.getAllHotelRooms(id);
    }

    @Override
    public Room getOne(int id) {
        return roomDao.findOne(id);
    }

    @Override
    public void update(int id, int hotelId, int roomNumber) {
        Room room = roomDao.findOne(id);
        Hotel hotel = hotelDao.findOne(hotelId);
        room.setHotel(hotel);
        room.setRoomNumber(roomNumber);
        roomDao.save(room);
    }


}
