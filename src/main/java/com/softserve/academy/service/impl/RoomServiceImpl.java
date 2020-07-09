package com.softserve.academy.service.impl;

import com.softserve.academy.dao.RoomDao;
import com.softserve.academy.model.Room;
import com.softserve.academy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private RoomDao roomDao;

    @Autowired
    public RoomServiceImpl(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public void save(Room room) {
        roomDao.save(room);
    }

    @Override
    public void delete(int id) {
        roomDao.delete(id);

    }

    @Override
    public List<Room> getAll() {
        return roomDao.findAll();
    }
}
