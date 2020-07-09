package com.softserve.academy.dao.impl;

import com.softserve.academy.dao.AbstractDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class GeneralDaoImpl<T, D extends Number> extends AbstractDao<T, D> {

    private final SessionFactory sessionFactory;

    public GeneralDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void save(T t) {
        getCurrentSession().save(t);
        getCurrentSession().flush();
    }

    @Transactional
    @Override
    public T findOne(D id) {
        return (T) getCurrentSession()
                .createQuery("select d from " + clazz.getName() + " d where d.id =:id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public List findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    @Transactional
    @Override
    public void update(T t) {

    }

    @Transactional
    @Override
    public void delete(D id) {
        getCurrentSession().createQuery("delete from " + clazz.getName() + " d where d.id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
