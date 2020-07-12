package com.softserve.academy.dao.impl;

import com.softserve.academy.dao.UserDao;
import com.softserve.academy.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GeneralDaoImpl<User, Integer> implements UserDao {
    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(User.class);
    }

    @Override
    public User findByName(String login) {
        return (User) getCurrentSession().createQuery("select u from User u where u.login=:login")
                .setParameter("login", login)
                .getSingleResult();
    }
}
