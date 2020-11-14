package com.simco.prickleback.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simco.prickleback.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findByOrderByNameAsc();

}
