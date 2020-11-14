package com.simco.prickleback.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.simco.prickleback.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findByOrderByNameAsc();

    @Query(value="SELECT * FROM cities c ORDER BY random() LIMIT :numberToReturn", nativeQuery=true)
    List<City> findRandomCities(@Param("numberToReturn") int num);

    // SELECT * FROM table_name OFFSET floor(random() * (SELECT COUNT(*) FROM table_name)) LIMIT 1;

}
