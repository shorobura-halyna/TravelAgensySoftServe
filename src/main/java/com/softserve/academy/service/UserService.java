package com.softserve.academy.service;

import com.softserve.academy.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void delete(int id);

    List<User> getAll();

    User getOne(int id);

    User loadUserWithBookings(int id);

    List<User> loadUsersWithBookings();

    void update(int userId, String firstName, String lastName, String login);
}
