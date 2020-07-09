package com.softserve.academy.dao.impl;

import com.softserve.academy.dao.HotelDao;
import com.softserve.academy.model.Hotel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDaoImpl extends GeneralDaoImpl<Hotel, Integer> implements HotelDao {

    @Autowired
    public HotelDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(Hotel.class);
    }
}
