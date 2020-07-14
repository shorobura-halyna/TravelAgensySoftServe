package com.softserve.academy.service.impl;

import com.softserve.academy.dao.CountryDao;
import com.softserve.academy.dao.HotelDao;
import com.softserve.academy.model.Country;
import com.softserve.academy.model.Hotel;
import com.softserve.academy.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {
    public final CountryDao countryDao;
    public final HotelDao hotelDao;

    @Autowired
    public CountryServiceImpl(CountryDao countryDao, HotelDao hotelDao) {
        this.countryDao = countryDao;
        this.hotelDao = hotelDao;
    }

    @Override
    public void delete(int id) {
        Country country = countryDao.findOne(id);
        for (Hotel hotel : country.getHotels()) {
            hotelDao.delete(hotel.getId());
        }
        countryDao.delete(id);
    }

    @Override
    public void save(Country country) {
        countryDao.save(country);
    }

    @Override
    public Country getOne(int id) {
        return countryDao.findOne(id);
    }

    @Override
    public List<Country> getAll() {
        return countryDao.findAll();
    }

    @Override
    public void update(int id, String name) {
      Country country = countryDao.findOne(id);
      country.setName(name);
      countryDao.save(country);
    }
}
