package com.softserve.academy.service;

import com.softserve.academy.model.Room;

import java.util.List;

public interface RoomService {
    void save(Room room, int hotelId);

    void delete(int id);

    Room getOne(int id);

    void update(int id, int hotelId, int roomNumber);

    List<Room> findAvailableRooms(int hotelId, String dateFrom, String dateTo);

    List<Room> getAllHotelRooms(int id);
}
