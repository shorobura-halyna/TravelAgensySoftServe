package com.softserve.academy.dao;

import com.softserve.academy.model.User;

public interface UserDao extends GeneralDao<User, Integer> {
    User findByName(String login);
}
