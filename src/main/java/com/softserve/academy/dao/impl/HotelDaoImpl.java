package com.softserve.academy.dao.impl;

import com.softserve.academy.dao.HotelDao;
import com.softserve.academy.model.Hotel;
import com.softserve.academy.model.Room;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HotelDaoImpl extends GeneralDaoImpl<Hotel, Integer> implements HotelDao {

    @Autowired
    public HotelDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(Hotel.class);
    }

    @Override
    public List<Hotel> getAllCountryHotel(int id) {
       return getCurrentSession().createQuery("select h from Hotel h where h.country.id=:id")
                .setParameter("id", id)
                .list();
    }
}
