package com.softserve.academy.dao.impl;

import com.softserve.academy.dao.RoomDao;
import com.softserve.academy.model.Room;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RoomDaoImpl extends GeneralDaoImpl<Room, Integer> implements RoomDao {
    @Autowired
    public RoomDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(Room.class);
    }

    @Transactional
    @Override
    public List<Room> getAllHotelRooms(int id) {
        return getCurrentSession().createQuery("select r from Room r where r.hotel.id=:id")
                .setParameter("id", id)
                .list();
    }

    @Override
    public List<Room> getAllHotelRoomsWithBookings(int id) {
        return getCurrentSession().createQuery("select r from Room r left join fetch r.bookings " +
                "where r.hotel.id=:id")
                .setParameter("id", id)
                .list();
    }
}
