package com.softserve.academy.service.impl;

import com.softserve.academy.dao.UserDao;
import com.softserve.academy.model.User;
import com.softserve.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
      userDao.save(user);
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);

    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }
}
