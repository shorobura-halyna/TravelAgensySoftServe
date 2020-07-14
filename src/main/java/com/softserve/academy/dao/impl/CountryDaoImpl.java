package com.softserve.academy.dao.impl;

import com.softserve.academy.dao.CountryDao;
import com.softserve.academy.model.Country;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDaoImpl extends GeneralDaoImpl<Country, Integer> implements CountryDao {
    @Autowired
    public CountryDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        setClazz(Country.class);
    }
}
