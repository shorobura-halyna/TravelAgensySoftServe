package com.softserve.academy.dao.impl;

import com.softserve.academy.dao.RoomDao;
import com.softserve.academy.model.Room;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDaoImpl extends GeneralDaoImpl<Room, Integer> implements RoomDao {
    @Autowired
    public RoomDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(Room.class);
    }
}
