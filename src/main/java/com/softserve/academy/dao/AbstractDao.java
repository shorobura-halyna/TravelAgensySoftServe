package com.softserve.academy.dao;

public abstract class AbstractDao<T, D extends Number> implements GeneralDao<T, D> {
    public Class<T> clazz;

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }
}
