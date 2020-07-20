package com.softserve.academy.dao.impl;

import com.softserve.academy.dao.UserDao;
import com.softserve.academy.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public User loadUserWithBookings(int id) {
        return (User) getCurrentSession()
                .createQuery("select u from User u left join fetch u.bookings where u.id=:id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<User> loadUsersWithBookings() {
        return getCurrentSession()
                .createQuery("select distinct u from User u left join fetch u.bookings")
                .list();
    }
}
