package com.softserve.academy.dao;

import java.util.List;

public interface GeneralDao<T, D extends Number> {
    void save(T t);
    T findOne(D id);
    List<T> findAll();
    void delete(D id);
}
