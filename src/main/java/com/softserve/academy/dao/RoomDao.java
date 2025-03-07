package com.softserve.academy.dao;

import com.softserve.academy.model.Room;

import java.util.List;

public interface RoomDao extends GeneralDao<Room, Integer> {
    List<Room> getAllHotelRoomsWithBookings(int id);

    List<Room> getAllHotelRooms(int id);
}
