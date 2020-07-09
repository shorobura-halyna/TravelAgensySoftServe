package com.softserve.academy.service;

import com.softserve.academy.model.Room;

import java.util.List;

public interface RoomService {
    void save (Room room);
    void delete (int id);
    List<Room> getAll();
}
