package com.jpapostgresql.postgresql.services;

import com.jpapostgresql.postgresql.entity.Restaurant;
import com.jpapostgresql.postgresql.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;


    @Override
    public List<Restaurant> findAllRestaurant(){
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant findRestaurantById(int id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public List<Restaurant> findByCity(String city) {
        return restaurantRepository.findByCity(city);
    }

    @Override
    public List<Restaurant> findByCountry(String country) {
        return restaurantRepository.findByCountry(country);
    }

    @Override
    public List<Restaurant> findByLevelstar(String levelstar) {
        return restaurantRepository.findByLevelstar(levelstar);
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(int id, Restaurant restaurant) {
        Restaurant restToUpdate = restaurantRepository.findById(id).get();
        restToUpdate.setName(restaurant.getName());
        restToUpdate.setAddress(restaurant.getAddress());
        restToUpdate.setLevelstar(restaurant.getLevelstar());
        restToUpdate.setCity(restaurant.getCity());
        restToUpdate.setCountry(restaurant.getCountry());
        restToUpdate.setImage(restaurant.getImage());
        return restaurantRepository.save(restaurant);
    }
}
