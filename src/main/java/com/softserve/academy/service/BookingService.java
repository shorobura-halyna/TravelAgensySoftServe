package com.softserve.academy.service;

public interface BookingService {
    void bookRoom(int userId, int roomId, String dateFrom, String dateTo);
}
