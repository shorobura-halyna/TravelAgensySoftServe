package com.softserve.academy.service;

import com.softserve.academy.model.Country;

import java.util.List;

public interface CountryService {
    void delete(int id);
    void save (Country country);
    Country getOne(int id);
    List<Country> getAll();
    void update(int id, String name);
}
