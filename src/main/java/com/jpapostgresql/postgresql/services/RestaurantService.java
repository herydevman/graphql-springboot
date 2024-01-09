package com.jpapostgresql.postgresql.services;

import com.jpapostgresql.postgresql.entity.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> findAllRestaurant();

    Restaurant findRestaurantById(int id);

    List<Restaurant> findByCity(String city);

    List<Restaurant> findByCountry(String country);

    List<Restaurant> findByLevelstar(String levelstar);

    Restaurant createRestaurant(Restaurant restaurant);

    Restaurant updateRestaurant(int id, Restaurant restaurant);
}
