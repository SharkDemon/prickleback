package com.simco.prickleback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simco.prickleback.model.City;
import com.simco.prickleback.repo.CityRepository;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public List<City> getAllCities() {
        return repository.findByOrderByNameAsc();
    }

    public City getRandomCity() {
        return repository.findRandomCities(1).get(0);
    }

}
