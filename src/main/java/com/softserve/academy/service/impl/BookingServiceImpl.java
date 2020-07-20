package com.softserve.academy.service.impl;

import com.softserve.academy.dao.BookingDao;
import com.softserve.academy.dao.RoomDao;
import com.softserve.academy.dao.UserDao;
import com.softserve.academy.model.Booking;
import com.softserve.academy.model.Room;
import com.softserve.academy.model.User;
import com.softserve.academy.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private final UserDao userDao;
    private final RoomDao roomDao;
    private final BookingDao bookingDao;

    @Autowired
    public BookingServiceImpl(UserDao userDao, RoomDao roomDao, BookingDao bookingDao) {
        this.userDao = userDao;
        this.roomDao = roomDao;
        this.bookingDao = bookingDao;
    }

    @Override
    public void bookRoom(int userId, int roomId, String dateFrom, String dateTo) {
        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("yyyy-MM-d"));
        LocalDate to = LocalDate.parse(dateTo, DateTimeFormatter.ofPattern("yyyy-MM-d"));
        Booking booking = new Booking();
        booking.setDateFrom(from);
        booking.setDateTo(to);
        User user = userDao.findOne(userId);
        Room room = roomDao.findOne(roomId);
        booking.setUser(user);
        booking.setRoom(room);
        bookingDao.save(booking);
    }
}
