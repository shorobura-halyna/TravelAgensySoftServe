package com.softserve.academy.service.impl;

import com.softserve.academy.dao.BookingDao;
import com.softserve.academy.dao.HotelDao;
import com.softserve.academy.dao.RoomDao;
import com.softserve.academy.model.Booking;
import com.softserve.academy.model.Hotel;
import com.softserve.academy.model.Room;
import com.softserve.academy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    private final RoomDao roomDao;
    private final HotelDao hotelDao;
    private final BookingDao bookingDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao, HotelDao hotelDao, BookingDao bookingDao) {
        this.roomDao = roomDao;
        this.hotelDao = hotelDao;
        this.bookingDao = bookingDao;
    }

    @Override
    public void save(Room room, int hotelId) {
        Hotel hotel = hotelDao.findOne(hotelId);
        room.setHotel(hotel);
        roomDao.save(room);
    }

    @Override
    public void delete(int id) {
        Room room = roomDao.findOne(id);
        for (Booking booking : room.getBookings())
        bookingDao.delete(booking.getId());
        roomDao.delete(id);
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

    @Override
    public List<Room> findAvailableRooms(int hotelId, String dateFrom, String dateTo) {
        List<Room> availableRooms = new ArrayList<>();
        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("yyyy-MM-d"));
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("yyyy-MM-d"));
        List<Room> rooms = roomDao.getAllHotelRoomsWithBookings(hotelId);

        for (Room room : rooms) {
            boolean isRoomAvailable = true;
            for (Booking booking : room.getBookings()) {
                if(!booking.getDateTo().isBefore(from) && !booking.getDateFrom().isAfter(to)) {
                    isRoomAvailable = false;
                }
            }
            if (isRoomAvailable) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }

    @Override
    public List<Room> getAllHotelRooms(int id) {
        return roomDao.getAllHotelRooms(id);
    }


}
