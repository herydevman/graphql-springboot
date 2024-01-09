package com.jpapostgresql.postgresql.repository;

import com.jpapostgresql.postgresql.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    List<Restaurant> findByCity(String city);
    List<Restaurant> findByCountry(String country);

    List<Restaurant> findByLevelstar(String levelstar);

}
