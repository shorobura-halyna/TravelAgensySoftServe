package com.softserve.academy.dao;

import com.softserve.academy.model.User;

import java.util.List;

public interface UserDao extends GeneralDao<User, Integer> {
    User findByName(String login);

    User loadUserWithBookings(int id);

    List<User> loadUsersWithBookings();
}
