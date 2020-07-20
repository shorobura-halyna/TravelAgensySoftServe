package com.softserve.academy.dao.impl;

import com.softserve.academy.dao.BookingDao;
import com.softserve.academy.model.Booking;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookingDaoImpl extends GeneralDaoImpl<Booking, Integer> implements BookingDao {
    @Autowired
    public BookingDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(Booking.class);
    }
}
